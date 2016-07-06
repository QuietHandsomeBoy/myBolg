package com.pro.test.core.common.mybatis.dialect;

import com.alibaba.druid.util.StringUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by hxpeng on 2016/6/29.
 */
public class DialectHelper {
    public static Dialect getDialect(String databaseName) {
        if (StringUtils.isEmpty(databaseName)) {
            return null;
        }
        Dialect.DBVendor dbVendor = Dialect.DBVendor.valueOf(databaseName);
        if (dbVendor != null) {
            switch (dbVendor) {
                case Oracle:
                    return new OracleDialect();
                case MySQL:
                    return new MySQLDialect();
            }
        }
        return new OracleDialect();
    }

    public static Dialect getDialect(Connection con) {
        if (con == null) {
            return null;
        }
        String databaseName = null;
        try {
            databaseName = con.getMetaData().getDatabaseProductName();
        } catch (SQLException e) {
        }
        return getDialect(databaseName);
    }
}
