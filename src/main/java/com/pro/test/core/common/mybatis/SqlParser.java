package com.pro.test.core.common.mybatis;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLExpr;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLSelect;
import com.alibaba.druid.sql.ast.statement.SQLSelectGroupByClause;
import com.alibaba.druid.sql.ast.statement.SQLSelectQueryBlock;
import com.alibaba.druid.sql.ast.statement.SQLSelectStatement;
import com.alibaba.druid.sql.parser.SQLParserUtils;
import com.alibaba.druid.sql.parser.SQLStatementParser;
import com.alibaba.druid.sql.visitor.SQLASTOutputVisitor;
import com.pro.test.core.common.mybatis.dialect.Dialect;

import java.util.List;

/**
 * Created by hxpeng on 2016/6/29.
 */
public class SqlParser {
    public static String getCountSql(Dialect dialect, String sql)
    {
        StringBuffer from = new StringBuffer();
        StringBuffer where = new StringBuffer();
        StringBuffer groupBy = new StringBuffer();

        String dialectStr = dialect.getDBVendor().toLowerCase();

        SQLStatementParser parser = SQLParserUtils.createSQLStatementParser(sql, dialectStr);

        List<SQLStatement> stmtList = parser.parseStatementList();

        SQLASTOutputVisitor formVisitor = SQLUtils.createFormatOutputVisitor(from, stmtList, dialectStr);
        SQLASTOutputVisitor whereVisitor = SQLUtils.createFormatOutputVisitor(where, stmtList, dialectStr);
        SQLASTOutputVisitor groupByVisitor = SQLUtils.createFormatOutputVisitor(groupBy, stmtList, dialectStr);
        for (SQLStatement stmt : stmtList) {
            if ((stmt instanceof SQLSelectStatement))
            {
                SQLSelectStatement sstmt = (SQLSelectStatement)stmt;
                SQLSelect sqlselect = sstmt.getSelect();
                SQLSelectQueryBlock query = (SQLSelectQueryBlock)sqlselect.getQuery();

                query.getFrom().accept(formVisitor);

                SQLExpr sqlExpr = query.getWhere();
                if (sqlExpr != null) {
                    sqlExpr.accept(whereVisitor);
                }
                SQLSelectGroupByClause sqlSelectGroupByClause = query.getGroupBy();
                if (sqlSelectGroupByClause != null) {
                    sqlSelectGroupByClause.accept(groupByVisitor);
                }
            }
        }
        String countSql = "select count(*) from " + from.toString();

        countSql = countSql + (where.length() > 0 ? " where " + where.toString() : "");
        countSql = countSql + (groupBy.length() > 0 ? " " + groupBy.toString() : "");

        return countSql;
    }
}

