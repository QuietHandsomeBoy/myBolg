package com.pro.test.core.common.mybatis.dialect;

/**
 * Created by hxpeng on 2016/6/29.
 */
public class Dialect {
    public static final String SQL_END_DELIMITER = ";";

    public static enum DBVendor {
        MySQL, Oracle;

        private DBVendor() {
        }
    }

    private boolean delimiterFlag = false;

    public String getDBVendor() {
        throw new UnsupportedOperationException("there is no db vendor");
    }

    public boolean supportsLimit() {
        return true;
    }

    public boolean supportsLimitOffset() {
        return supportsLimit();
    }

    public boolean hasDelimiter() {
        return this.delimiterFlag;
    }

    public String getLimitString(String sql, int offset, int limit) {
        throw new UnsupportedOperationException("paged queries not supported");
    }

    protected String trimDelimiter(String sql) {
        if ((sql == null) || (sql.length() <= 0)) {
            return null;
        }
        this.delimiterFlag = sql.endsWith(";");

        return this.delimiterFlag ? sql.substring(0, sql.length() - 1 - ";".length()) : sql;
    }

    public String getSequenceString(String sequenceName) {
        throw new UnsupportedOperationException("getSequenceString not supported");
    }

    public String getSequenceString(String sequenceName, boolean autoFlag) {
        throw new UnsupportedOperationException("getSequenceString not supported");
    }

    public String getSequenceString(String tableName, String sequenceName) {
        throw new UnsupportedOperationException("getSequenceString not supported");
    }

    public String getSequenceColumn(String sequenceName) {
        throw new UnsupportedOperationException("getSequenceString not supported");
    }
}
