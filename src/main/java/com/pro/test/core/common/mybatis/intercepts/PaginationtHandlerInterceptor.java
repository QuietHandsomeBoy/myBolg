package com.pro.test.core.common.mybatis.intercepts;

import com.pro.test.core.common.mybatis.ContextData;
import com.pro.test.core.common.mybatis.dialect.Dialect;
import com.pro.test.core.common.mybatis.dialect.DialectHelper;
import com.pro.test.core.common.mybatis.entity.Pagination;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.Properties;

/**
 * Created by hxpeng on 2016/7/25.
 */
@Intercepts({@org.apache.ibatis.plugin.Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class})})
public class PaginationtHandlerInterceptor implements Interceptor {

    private static final Logger logger = LoggerFactory.getLogger(PaginationtHandlerInterceptor.class);
    private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
    private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        if ((invocation.getTarget() instanceof RoutingStatementHandler)) {
            RoutingStatementHandler statement = (RoutingStatementHandler) invocation.getTarget();
            MetaObject metaStatementHandler = MetaObject.forObject(statement, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
            RowBounds rowBounds = (RowBounds) metaStatementHandler.getValue("delegate.rowBounds");
            if ((rowBounds != null) && (rowBounds.getLimit() < Integer.MAX_VALUE)) {
                ContextData contextData = (ContextData) metaStatementHandler.getValue("delegate.boundSql.parameterObject");
                Pagination pagination = null;
                if ((contextData == null) || ((pagination = contextData.getPagination()) == null)) {
                    pagination = new Pagination();
                }
                int offset = pagination.getCurrentPageStartRecord() - 1;
                int limit = pagination.getPageSize();

                MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
                if ((limit > 0) && (limit < Integer.MAX_VALUE)) {
                    BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");

                    Object parameterObject = boundSql.getParameterObject();
                    if (parameterObject == null) {
                        throw new NullPointerException("parameterObject is null!");
                    }
                    Connection con = (Connection) invocation.getArgs()[0];
                    Dialect dialect = DialectHelper.getDialect(con);
                    String sql = boundSql.getSql();
                    String paginationSql = dialect.getLimitString(boundSql.getSql(), offset, limit);

                    metaStatementHandler.setValue("delegate.boundSql.sql", paginationSql);

                    metaStatementHandler.setValue("delegate.rowBounds.offset", Integer.valueOf(0));
                    metaStatementHandler.setValue("delegate.rowBounds.limit", Integer.valueOf(Integer.MAX_VALUE));
                    if (pagination.getTotalRecordsQueryFlag()) {
                        setPageParameter(con, dialect, sql, mappedStatement, boundSql, pagination);
                    }
                }
            }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        if ((o instanceof StatementHandler)) {
            return Plugin.wrap(o, this);
        }
        return o;
    }

    @Override
    public void setProperties(Properties properties) {
    }

    private void setPageParameter(Connection connection, Dialect dialect, String sql, MappedStatement mappedStatement, BoundSql boundSql, Pagination pagination) {}
}
