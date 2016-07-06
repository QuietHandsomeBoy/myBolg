package com.pro.test.core.common.mybatis.dialect;

/**
 * Created by hxpeng on 2016/6/29.
 */
public class OracleDialect extends Dialect {
    public String getDBVendor() {
        return Dialect.DBVendor.Oracle.name();
    }

    public String getLimitString(String sql, int offset, int limit) {
        sql = trimDelimiter(sql);

        boolean isForUpdate = false;
        if (sql.toLowerCase().endsWith(" for update")) {
            sql = sql.substring(0, sql.length() - 11);
            isForUpdate = true;
        }
        StringBuffer stringBuffer = new StringBuffer(sql.length() + 100);

        stringBuffer.append("select * from ( select row_.*, rownum rownum_ from ( ");
        stringBuffer.append(sql);
        stringBuffer.append(" ) row_ where rownum <= " + (offset + limit) + " ) where rownum_ > " + offset);
        if (isForUpdate) {
            stringBuffer.append(" for update");
        }
        return stringBuffer.toString();
    }

    public String getSequenceString(String sequenceName) {
        return "select " + getSequenceColumn(sequenceName) + " from dual";
    }

    public String getSequenceString(String sequenceName, boolean autoFlag) {
        return getSequenceString(sequenceName);
    }

    public String getSequenceColumn(String sequenceName) {
        return sequenceName + ".nextval";
    }
}
