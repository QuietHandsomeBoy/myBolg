package com.pro.test.core.common.mybatis.dialect;

/**
 * Created by hxpeng on 2016/6/29.
 */
public class MySQLDialect extends Dialect {
    public String getDBVendor() {
        return Dialect.DBVendor.MySQL.name();
    }

    public String getLimitString(String sql, int offset, int limit) {
        sql = trimDelimiter(sql);

        StringBuffer stringBuffer = new StringBuffer(sql.length() + 20);

        stringBuffer.append(sql);
        if (offset > 0) {
            stringBuffer.append(" limit ").append(offset).append(',').append(limit);
        } else {
            stringBuffer.append(" limit ").append(limit);
        }
        if (super.hasDelimiter()) {
            stringBuffer.append(";");
        }
        return stringBuffer.toString();
    }

    public String getSequenceString(String sequenceName) {
        return "SELECT " + getSequenceColumn(sequenceName);
    }

    public String getSequenceString(String sequenceName, boolean autoFlag) {
        return autoFlag ? getSequenceString(sequenceName) : null;
    }

    public String getSequenceColumn(String sequenceName) {
        return "nextval('" + sequenceName + "')";
    }
}
