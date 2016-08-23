package com.pro.test.core.common.mybatis.intercepts;

import com.pro.test.core.common.mybatis.ContextData;
import com.pro.test.core.common.mybatis.SqlParser;
import com.pro.test.core.common.mybatis.dialect.Dialect;
import com.pro.test.core.common.mybatis.dialect.DialectHelper;
import com.pro.test.core.common.mybatis.entity.Pagination;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by hxpeng on 2016/7/25.
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class})})
public class PaginationtHandlerInterceptor implements Interceptor{

    /**
     * 日志处理
     */
    private static final Logger logger = LoggerFactory.getLogger(PaginationtHandlerInterceptor.class);

    /**
     * DefaultObjectFactory
     */
    private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();

    /**
     * DefaultObjectWrapperFactory
     */
    private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        if (invocation.getTarget() instanceof RoutingStatementHandler) {
            RoutingStatementHandler statement = (RoutingStatementHandler) invocation.getTarget();
            MetaObject metaStatementHandler = MetaObject.forObject(statement, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
            RowBounds rowBounds = (RowBounds) metaStatementHandler.getValue("delegate.rowBounds");

            if (rowBounds != null && rowBounds.getLimit() < RowBounds.NO_ROW_LIMIT) {
                //int offset = rowBounds.getOffset();
                //int limit = rowBounds.getLimit();

                ContextData contextData = (ContextData) metaStatementHandler.getValue("delegate.boundSql.parameterObject");
                Pagination pagination = null;

                if (contextData == null || (pagination = contextData.getPagination()) == null) {
                    pagination = new Pagination();
                }

                int offset = pagination.getCurrentPageStartRecord() - 1;
                int limit = pagination.getPageSize();

                MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");

                if (limit > 0 && limit < RowBounds.NO_ROW_LIMIT) {
                    BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");

                    // 分页SQL<select>中parameterType属性对应的实体参数，即Mapper接口中执行分页方法的参数,该参数不得为空
                    Object parameterObject = boundSql.getParameterObject();

                    if (parameterObject == null) {
                        throw new NullPointerException("parameterObject is null!");
                    } else {
                        Connection con = (Connection) invocation.getArgs()[0];
                        Dialect dialect = DialectHelper.getDialect(con);
                        String sql = boundSql.getSql();
                        String paginationSql = dialect.getLimitString(boundSql.getSql(), offset, limit);

                        metaStatementHandler.setValue("delegate.boundSql.sql", paginationSql);

                        // 采用物理分页后，就不需要mybatis的内存分页了，所以重置下面的两个参数
                        metaStatementHandler.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET);
                        metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);

                        if (pagination.getTotalRecordsQueryFlag()) {
                            // 重设分页参数里的总页数等
                            setPageParameter(con, dialect, sql, mappedStatement, boundSql, pagination);
                        }
                    }
                }
            }
        }

        return invocation.proceed();
    }


    /**
     * 插入目标对象
     *
     * @param o 目标对象
     * @return 返回目标对象
     */
    @Override
    public Object plugin(Object o) {
        if (o instanceof StatementHandler) {
            return Plugin.wrap(o, this);
        } else {
            return o;
        }
    }

    /**
     * 设置属性
     *
     * @param properties 参数
     */
    @Override
    public void setProperties(Properties properties) {

    }


    /**
     * 从数据库里查询总的记录数并计算总页数，回写进分页参数<code>Pagination</code>,这样调用
     * 者就可用通过 分页参数<code>Pagination</code>获得相关信息。
     *
     * @param connection      数据库连接对像
     * @param dialect         数据库方言
     * @param sql             SQL语句
     * @param mappedStatement 映射配置
     * @param boundSql        绑定的SQL语句
     * @param pagination      分页对象
     */
    private static void setPageParameter(Connection connection, Dialect dialect, String sql,
                                  MappedStatement mappedStatement, BoundSql boundSql, Pagination pagination) {
        // 记录总记录数
        String countSql = SqlParser.getCountSql(dialect, sql);
        PreparedStatement countStmt = null;
        ResultSet rs = null;

        try {
            countStmt = connection.prepareStatement(countSql);
            BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(), countSql,
                    boundSql.getParameterMappings(), boundSql.getParameterObject());

            new DefaultParameterHandler(mappedStatement, boundSql.getParameterObject(), countBS).setParameters(countStmt);

            rs = countStmt.executeQuery();
            int totalCount = 0;

            if (rs.next()) {
                totalCount = rs.getInt(1);
            }

            pagination.setTotalPages(pagination.getTotalPages());
            pagination.setTotalRecords(totalCount);
        } catch (SQLException e) {
            logger.info("Exception: ", e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                logger.info("Exception: ", e);
            }

            try {
                if (countStmt != null) {
                    countStmt.close();
                }
            } catch (SQLException e) {
                logger.info("Exception: ", e);
            }
        }
    }
}
