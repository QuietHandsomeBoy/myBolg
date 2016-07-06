package com.pro.test.core.common.mybatis.dao;

import com.pro.test.core.common.exception.HandleException;
import com.pro.test.core.common.global.BaseVariables;
import com.pro.test.core.common.mybatis.MappingConvertor;
import com.pro.test.core.common.mybatis.dialect.Dialect;
import com.pro.test.core.common.mybatis.dialect.DialectHelper;
import com.pro.test.core.util.ReflectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hxpeng on 2016/6/29.
 */
public class BaseDAO<E> {
    private static final Logger logger = LoggerFactory.getLogger(BaseDAO.class);
    protected Class<E> entityClass;
    protected static String logHeader = "[SQL]: ";
    protected boolean sqlLogFlag = false;
    public static final String DATABASE_NAME_ORACLE = "Oracle";
    public static final String DATABASE_NAME_MYSQL = "MySQL";

    public BaseDAO() {
        this.entityClass = ReflectUtils.getSuperClassGenricType(getClass());
    }

    public BaseDAO(Class<E> clazz) {
        this.entityClass = clazz;
    }

    public BaseDAO(boolean sqlLogFlag) {
        this();
    }

    public int save(Connection con, String sql, List<Object> params)
            throws SQLException, HandleException {
        int res = 0;
        if ((sql == null) || (sql.trim().length() <= 0)) {
            return res;
        }
        if ((this.sqlLogFlag) || (BaseVariables.global_sql_log_flag)) {
            logger.info(logHeader + sql);
        }
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);

            setParamsValue(ps, params);

            res = ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("SQLException: [" + sql + "]", e);
            throw e;
        } catch (HandleException e) {
            logger.error("HandleException: [" + sql + "]", e);
            throw e;
        } finally {
            releaseResources(ps, null);
        }
        return res;
    }

    public int save(Connection con, String sql, Map<String, Object> params)
            throws SQLException, HandleException {
        int res = 0;
        if ((sql == null) || (sql.trim().length() <= 0)) {
            return res;
        }
        if ((this.sqlLogFlag) || (BaseVariables.global_sql_log_flag)) {
            logger.info(logHeader + sql);
        }
        PreparedStatement ps = null;
        try {
            Map<Integer, String> seqMap = new HashMap();

            ps = con.prepareStatement(parseSQL(sql, seqMap));

            setNamedParams(ps, params, seqMap);

            res = ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("SQLException: [" + sql + "]", e);
            throw e;
        } catch (HandleException e) {
            logger.error("HandleException: [" + sql + "]", e);
            throw e;
        } finally {
            releaseResources(ps, null);
        }
        return res;
    }

    public E findUnique(Connection con, String sql, List<Object> params)
            throws SQLException, HandleException {
        if ((con == null) || (sql == null) || (sql.trim().length() <= 0)) {
            return null;
        }
        if ((this.sqlLogFlag) || (BaseVariables.global_sql_log_flag)) {
            logger.info(logHeader + sql);
        }
        E res = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);

            setParamsValue(ps, params);

            rs = ps.executeQuery();

            List<E> resultList = convertToEitity(rs);
            if ((resultList != null) && (resultList.size() > 0)) {
                res = resultList.get(0);
            }
        } catch (SQLException e) {
            logger.error("SQLException: [" + sql + "]", e);
            throw e;
        } catch (HandleException e) {
            logger.error("HandleException: [" + sql + "]", e);
            throw e;
        } finally {
            releaseResources(ps, null);
        }
        return res;
    }

    public E findUnique(Connection con, String sql, Map<String, Object> params)
            throws SQLException, HandleException {
        if ((con == null) || (sql == null) || (sql.trim().length() <= 0)) {
            return null;
        }
        if ((this.sqlLogFlag) || (BaseVariables.global_sql_log_flag)) {
            logger.info(logHeader + sql);
        }
        E res = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Map<Integer, String> seqMap = new HashMap();

            ps = con.prepareStatement(parseSQL(sql, seqMap));

            setNamedParams(ps, params, seqMap);

            rs = ps.executeQuery();

            List<E> resultList = convertToEitity(rs);
            if ((resultList != null) && (resultList.size() > 0)) {
                res = resultList.get(0);
            }
        } catch (SQLException e) {
            logger.error("SQLException: [" + sql + "]", e);
            throw e;
        } catch (HandleException e) {
            logger.error("HandleException: [" + sql + "]", e);
            throw e;
        } finally {
            releaseResources(ps, null);
        }
        return res;
    }

    public List<E> findList(Connection con, String sql, List<Object> params)
            throws SQLException, HandleException {
        if ((con == null) || (sql == null) || (sql.trim().length() <= 0)) {
            return null;
        }
        if ((this.sqlLogFlag) || (BaseVariables.global_sql_log_flag)) {
            logger.info(logHeader + sql);
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<E> resultList = null;
        try {
            ps = con.prepareStatement(sql);

            setParamsValue(ps, params);

            rs = ps.executeQuery();

            resultList = convertToEitity(rs);
        } catch (SQLException e) {
            logger.error("SQLException: [" + sql + "]", e);
            throw e;
        } catch (HandleException e) {
            logger.error("HandleException: [" + sql + "]", e);
            throw e;
        } finally {
            releaseResources(ps, rs);
        }
        return resultList;
    }

    public List<E> findList(Connection con, String sql, Map<String, Object> params)
            throws SQLException, HandleException {
        if ((con == null) || (sql == null) || (sql.trim().length() <= 0)) {
            return null;
        }
        if ((this.sqlLogFlag) || (BaseVariables.global_sql_log_flag)) {
            logger.info(logHeader + sql);
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<E> resultList = null;
        try {
            Map<Integer, String> seqMap = new HashMap();

            ps = con.prepareStatement(parseSQL(sql, seqMap));

            setNamedParams(ps, params, seqMap);

            rs = ps.executeQuery();

            resultList = convertToEitity(rs);
        } catch (SQLException e) {
            logger.error("SQLException: [" + sql + "]", e);
            throw e;
        } catch (HandleException e) {
            logger.error("HandleException: [" + sql + "]", e);
            throw e;
        } finally {
            releaseResources(ps, rs);
        }
        return resultList;
    }

    public List<E> findList(Connection con, String sql, List<Object> params, int offset, int limit)
            throws SQLException, HandleException {
        if ((con == null) || (sql == null) || (sql.trim().length() <= 0)) {
            return null;
        }
        if ((this.sqlLogFlag) || (BaseVariables.global_sql_log_flag)) {
            logger.info(logHeader + sql);
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<E> resultList = null;

        String pagingSql = getDialect(con).getLimitString(sql, offset, limit);
        try {
            ps = con.prepareStatement(pagingSql);

            setParamsValue(ps, params);

            rs = ps.executeQuery();

            resultList = convertToEitity(rs);
        } catch (SQLException e) {
            logger.error("SQLException: [" + pagingSql + "]", e);
            throw e;
        } catch (HandleException e) {
            logger.error("HandleException: [" + pagingSql + "]", e);
            throw e;
        } finally {
            releaseResources(ps, rs);
        }
        return resultList;
    }

    public List<E> findList(Connection con, String sql, Map<String, Object> params, int offset, int limit)
            throws SQLException, HandleException {
        if ((con == null) || (sql == null) || (sql.trim().length() <= 0)) {
            return null;
        }
        if ((this.sqlLogFlag) || (BaseVariables.global_sql_log_flag)) {
            logger.info(logHeader + sql);
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<E> resultList = null;

        Map<Integer, String> seqMap = new HashMap();

        String pagingSql = parseSQL(sql, seqMap);
        pagingSql = getDialect(con).getLimitString(pagingSql, offset, limit);
        try {
            ps = con.prepareStatement(pagingSql);

            setNamedParams(ps, params, seqMap);

            rs = ps.executeQuery();

            resultList = convertToEitity(rs);
        } catch (SQLException e) {
            logger.error("SQLException: [" + pagingSql + "]", e);
            throw e;
        } catch (HandleException e) {
            logger.error("HandleException: [" + pagingSql + "]", e);
            throw e;
        } finally {
            releaseResources(ps, rs);
        }
        return resultList;
    }

    public Map<?, ?> findUniqueForMap(Connection con, String sql, List<Object> params)
            throws SQLException, HandleException {
        if ((con == null) || (sql == null) || (sql.trim().length() <= 0)) {
            return null;
        }
        if ((this.sqlLogFlag) || (BaseVariables.global_sql_log_flag)) {
            logger.info(logHeader + sql);
        }
        Map<?, ?> res = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);

            setParamsValue(ps, params);

            rs = ps.executeQuery();

            List<Map<?, ?>> resultList = convertToMap(rs);
            if ((resultList != null) && (resultList.size() > 0)) {
                res = (Map) resultList.get(0);
            }
        } catch (SQLException e) {
            logger.error("SQLException: [" + sql + "]", e);
            throw e;
        } catch (HandleException e) {
            logger.error("HandleException: [" + sql + "]", e);
            throw e;
        } finally {
            releaseResources(ps, null);
        }
        return res;
    }

    public Map<?, ?> findUniqueForMap(Connection con, String sql, Map<String, Object> params)
            throws SQLException, HandleException {
        if ((con == null) || (sql == null) || (sql.trim().length() <= 0)) {
            return null;
        }
        if ((this.sqlLogFlag) || (BaseVariables.global_sql_log_flag)) {
            logger.info(logHeader + sql);
        }
        Map<?, ?> res = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Map<Integer, String> seqMap = new HashMap();

            ps = con.prepareStatement(parseSQL(sql, seqMap));

            setNamedParams(ps, params, seqMap);

            rs = ps.executeQuery();

            List<Map<?, ?>> resultList = convertToMap(rs);
            if ((resultList != null) && (resultList.size() > 0)) {
                res = (Map) resultList.get(0);
            }
        } catch (SQLException e) {
            logger.error("SQLException: [" + sql + "]", e);
            throw e;
        } catch (HandleException e) {
            logger.error("HandleException: [" + sql + "]", e);
            throw e;
        } finally {
            releaseResources(ps, null);
        }
        return res;
    }

    public List<Map<?, ?>> findListForMap(Connection con, String sql, List<Object> params)
            throws SQLException, HandleException {
        if ((con == null) || (sql == null) || (sql.trim().length() <= 0)) {
            return null;
        }
        if ((this.sqlLogFlag) || (BaseVariables.global_sql_log_flag)) {
            logger.info(logHeader + sql);
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Map<?, ?>> resultList = null;
        try {
            ps = con.prepareStatement(sql);

            setParamsValue(ps, params);

            rs = ps.executeQuery();

            resultList = convertToMap(rs);
        } catch (SQLException e) {
            logger.error("SQLException: [" + sql + "]", e);
            throw e;
        } catch (HandleException e) {
            logger.error("HandleException: [" + sql + "]", e);
            throw e;
        } finally {
            releaseResources(ps, rs);
        }
        return resultList;
    }

    public List<Map<?, ?>> findListForMap(Connection con, String sql, Map<String, Object> params)
            throws SQLException, HandleException {
        if ((con == null) || (sql == null) || (sql.trim().length() <= 0)) {
            return null;
        }
        if ((this.sqlLogFlag) || (BaseVariables.global_sql_log_flag)) {
            logger.info(logHeader + sql);
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Map<?, ?>> resultList = null;
        try {
            Map<Integer, String> seqMap = new HashMap();

            ps = con.prepareStatement(parseSQL(sql, seqMap));

            setNamedParams(ps, params, seqMap);

            rs = ps.executeQuery();

            resultList = convertToMap(rs);
        } catch (SQLException e) {
            logger.error("SQLException: [" + sql + "]", e);
            throw e;
        } catch (HandleException e) {
            logger.error("HandleException: [" + sql + "]", e);
            throw e;
        } finally {
            releaseResources(ps, rs);
        }
        return resultList;
    }

    public List<Map<?, ?>> findListForMap(Connection con, String sql, List<Object> params, int offset, int limit)
            throws SQLException, HandleException {
        if ((con == null) || (sql == null) || (sql.trim().length() <= 0)) {
            return null;
        }
        if ((this.sqlLogFlag) || (BaseVariables.global_sql_log_flag)) {
            logger.info(logHeader + sql);
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Map<?, ?>> resultList = null;

        String pagingSql = getDialect(con).getLimitString(sql, offset, limit);
        try {
            ps = con.prepareStatement(pagingSql);

            setParamsValue(ps, params);

            rs = ps.executeQuery();

            resultList = convertToMap(rs);
        } catch (SQLException e) {
            logger.error("SQLException: [" + pagingSql + "]", e);
            throw e;
        } catch (HandleException e) {
            logger.error("HandleException: [" + pagingSql + "]", e);
            throw e;
        } finally {
            releaseResources(ps, rs);
        }
        return resultList;
    }

    public List<Map<?, ?>> findListForMap(Connection con, String sql, Map<String, Object> params, int offset, int limit)
            throws SQLException, HandleException {
        if ((con == null) || (sql == null) || (sql.trim().length() <= 0)) {
            return null;
        }
        if ((this.sqlLogFlag) || (BaseVariables.global_sql_log_flag)) {
            logger.info(logHeader + sql);
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Map<?, ?>> resultList = null;

        Map<Integer, String> seqMap = new HashMap();

        String pagingSql = parseSQL(sql, seqMap);
        pagingSql = getDialect(con).getLimitString(pagingSql, offset, limit);
        try {
            ps = con.prepareStatement(pagingSql);

            setNamedParams(ps, params, seqMap);

            rs = ps.executeQuery();

            resultList = convertToMap(rs);
        } catch (SQLException e) {
            logger.error("SQLException: [" + pagingSql + "]", e);
            throw e;
        } catch (HandleException e) {
            logger.error("HandleException: [" + pagingSql + "]", e);
            throw e;
        } finally {
            releaseResources(ps, rs);
        }
        return resultList;
    }

    public Long findCount(Connection con, String sql, List<Object> params)
            throws SQLException, HandleException {
        if ((con == null) || (sql == null) || (sql.trim().length() <= 0)) {
            return null;
        }
        if ((this.sqlLogFlag) || (BaseVariables.global_sql_log_flag)) {
            logger.info(logHeader + sql);
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        Long countValue = null;
        try {
            ps = con.prepareStatement("select count(1) from (" + sql + ")");

            setParamsValue(ps, params);

            rs = ps.executeQuery();
            if (rs.next()) {
                countValue = new Long(rs.getLong(1));
            }
        } catch (SQLException e) {
            logger.error("SQLException: [" + sql + "]", e);
            throw e;
        } catch (HandleException e) {
            logger.error("HandleException: [" + sql + "]", e);
            throw e;
        } finally {
            releaseResources(ps, rs);
        }
        return countValue;
    }

    public Long findCount(Connection con, String sql, Map<String, Object> params)
            throws SQLException, HandleException {
        if ((con == null) || (sql == null) || (sql.trim().length() <= 0)) {
            return null;
        }
        if ((this.sqlLogFlag) || (BaseVariables.global_sql_log_flag)) {
            logger.info(logHeader + sql);
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        Long countValue = null;
        try {
            Map<Integer, String> seqMap = new HashMap();

            ps = con.prepareStatement("select count(1) from (" + parseSQL(sql, seqMap) + ")");

            setNamedParams(ps, params, seqMap);

            rs = ps.executeQuery();
            if (rs.next()) {
                countValue = new Long(rs.getLong(1));
            }
        } catch (SQLException e) {
            logger.error("SQLException: [" + sql + "]", e);
            throw e;
        } catch (HandleException e) {
            logger.error("HandleException: [" + sql + "]", e);
            throw e;
        } finally {
            releaseResources(ps, rs);
        }
        return countValue;
    }

    public Object findForObject(Connection con, String sql, List<Object> params)
            throws SQLException, HandleException {
        if ((con == null) || (sql == null) || (sql.trim().length() <= 0)) {
            return null;
        }
        if ((this.sqlLogFlag) || (BaseVariables.global_sql_log_flag)) {
            logger.info(logHeader + sql);
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        Object res = null;
        try {
            ps = con.prepareStatement(sql);

            setParamsValue(ps, params);

            rs = ps.executeQuery();
            if (rs.next()) {
                res = rs.getObject(1);
            }
        } catch (SQLException e) {
            logger.error("SQLException: [" + sql + "]", e);
            throw e;
        } catch (HandleException e) {
            logger.error("HandleException: [" + sql + "]", e);
            throw e;
        } finally {
            releaseResources(ps, rs);
        }
        return res;
    }

    public Integer findForInteger(Connection con, String sql, List<Object> params)
            throws SQLException, HandleException {
        if ((con == null) || (sql == null) || (sql.trim().length() <= 0)) {
            return null;
        }
        if ((this.sqlLogFlag) || (BaseVariables.global_sql_log_flag)) {
            logger.info(logHeader + sql);
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer res = null;
        try {
            ps = con.prepareStatement(sql);

            setParamsValue(ps, params);

            rs = ps.executeQuery();
            if (rs.next()) {
                res = new Integer(rs.getInt(1));
            }
        } catch (SQLException e) {
            logger.error("SQLException: [" + sql + "]", e);
            throw e;
        } catch (HandleException e) {
            logger.error("HandleException: [" + sql + "]", e);
            throw e;
        } finally {
            releaseResources(ps, rs);
        }
        return res;
    }

    public Long findForLong(Connection con, String sql, List<Object> params)
            throws SQLException, HandleException {
        if ((con == null) || (sql == null) || (sql.trim().length() <= 0)) {
            return null;
        }
        if ((this.sqlLogFlag) || (BaseVariables.global_sql_log_flag)) {
            logger.info(logHeader + sql);
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        Long res = null;
        try {
            ps = con.prepareStatement(sql);

            setParamsValue(ps, params);

            rs = ps.executeQuery();
            if (rs.next()) {
                res = new Long(rs.getLong(1));
            }
        } catch (SQLException e) {
            logger.error("SQLException: [" + sql + "]", e);
            throw e;
        } catch (HandleException e) {
            logger.error("HandleException: [" + sql + "]", e);
            throw e;
        } finally {
            releaseResources(ps, rs);
        }
        return res;
    }

    public String findForString(Connection con, String sql, List<Object> params)
            throws SQLException, HandleException {
        if ((con == null) || (sql == null) || (sql.trim().length() <= 0)) {
            return null;
        }
        if ((this.sqlLogFlag) || (BaseVariables.global_sql_log_flag)) {
            logger.info(logHeader + sql);
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        String res = null;
        try {
            ps = con.prepareStatement(sql);

            setParamsValue(ps, params);

            rs = ps.executeQuery();
            if (rs.next()) {
                res = new String(rs.getString(1));
            }
        } catch (SQLException e) {
            logger.error("SQLException: [" + sql + "]", e);
            throw e;
        } catch (HandleException e) {
            logger.error("HandleException: [" + sql + "]", e);
            throw e;
        } finally {
            releaseResources(ps, rs);
        }
        return res;
    }

    public BigDecimal findForBigDecimal(Connection con, String sql, List<Object> params)
            throws SQLException, HandleException {
        if ((con == null) || (sql == null) || (sql.trim().length() <= 0)) {
            return null;
        }
        if ((this.sqlLogFlag) || (BaseVariables.global_sql_log_flag)) {
            logger.info(logHeader + sql);
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        BigDecimal res = null;
        try {
            ps = con.prepareStatement(sql);

            setParamsValue(ps, params);

            rs = ps.executeQuery();
            if (rs.next()) {
                res = rs.getBigDecimal(1);
            }
        } catch (SQLException e) {
            logger.error("SQLException: [" + sql + "]", e);
            throw e;
        } catch (HandleException e) {
            logger.error("HandleException: [" + sql + "]", e);
            throw e;
        } finally {
            releaseResources(ps, rs);
        }
        return res;
    }

    public Date findForDate(Connection con, String sql, List<Object> params)
            throws SQLException, HandleException {
        if ((con == null) || (sql == null) || (sql.trim().length() <= 0)) {
            return null;
        }
        if ((this.sqlLogFlag) || (BaseVariables.global_sql_log_flag)) {
            logger.info(logHeader + sql);
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        Date res = null;
        try {
            ps = con.prepareStatement(sql);

            setParamsValue(ps, params);

            rs = ps.executeQuery();
            if (rs.next()) {
                Timestamp timestamp = rs.getTimestamp(1);
                if (timestamp != null) {
                    res = new Date(timestamp.getTime());
                }
            }
        } catch (SQLException e) {
            logger.error("SQLException: [" + sql + "]", e);
            throw e;
        } catch (HandleException e) {
            logger.error("HandleException: [" + sql + "]", e);
            throw e;
        } finally {
            releaseResources(ps, rs);
        }
        return res;
    }

    public Object findForObject(Connection con, String sql, Map<String, Object> params)
            throws SQLException, HandleException {
        if ((con == null) || (sql == null) || (sql.trim().length() <= 0)) {
            return null;
        }
        if ((this.sqlLogFlag) || (BaseVariables.global_sql_log_flag)) {
            logger.info(logHeader + sql);
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        Object res = null;
        try {
            Map<Integer, String> seqMap = new HashMap();

            ps = con.prepareStatement(parseSQL(sql, seqMap));

            setNamedParams(ps, params, seqMap);

            rs = ps.executeQuery();
            if (rs.next()) {
                res = rs.getObject(1);
            }
        } catch (SQLException e) {
            logger.error("SQLException: [" + sql + "]", e);
            throw e;
        } catch (HandleException e) {
            logger.error("HandleException: [" + sql + "]", e);
            throw e;
        } finally {
            releaseResources(ps, rs);
        }
        return res;
    }

    public Integer findForInteger(Connection con, String sql, Map<String, Object> params)
            throws SQLException, HandleException {
        if ((con == null) || (sql == null) || (sql.trim().length() <= 0)) {
            return null;
        }
        if ((this.sqlLogFlag) || (BaseVariables.global_sql_log_flag)) {
            logger.info(logHeader + sql);
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer res = null;
        try {
            Map<Integer, String> seqMap = new HashMap();

            ps = con.prepareStatement(parseSQL(sql, seqMap));

            setNamedParams(ps, params, seqMap);

            rs = ps.executeQuery();
            if (rs.next()) {
                res = new Integer(rs.getInt(1));
            }
        } catch (SQLException e) {
            logger.error("SQLException: [" + sql + "]", e);
            throw e;
        } catch (HandleException e) {
            logger.error("HandleException: [" + sql + "]", e);
            throw e;
        } finally {
            releaseResources(ps, rs);
        }
        return res;
    }

    public Long findForLong(Connection con, String sql, Map<String, Object> params)
            throws SQLException, HandleException {
        if ((con == null) || (sql == null) || (sql.trim().length() <= 0)) {
            return null;
        }
        if ((this.sqlLogFlag) || (BaseVariables.global_sql_log_flag)) {
            logger.info(logHeader + sql);
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        Long res = null;
        try {
            Map<Integer, String> seqMap = new HashMap();

            ps = con.prepareStatement(parseSQL(sql, seqMap));

            setNamedParams(ps, params, seqMap);

            rs = ps.executeQuery();
            if (rs.next()) {
                res = new Long(rs.getLong(1));
            }
        } catch (SQLException e) {
            logger.error("SQLException: [" + sql + "]", e);
            throw e;
        } catch (HandleException e) {
            logger.error("HandleException: [" + sql + "]", e);
            throw e;
        } finally {
            releaseResources(ps, rs);
        }
        return res;
    }

    public String findForString(Connection con, String sql, Map<String, Object> params)
            throws SQLException, HandleException {
        if ((con == null) || (sql == null) || (sql.trim().length() <= 0)) {
            return null;
        }
        if ((this.sqlLogFlag) || (BaseVariables.global_sql_log_flag)) {
            logger.info(logHeader + sql);
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        String res = null;
        try {
            Map<Integer, String> seqMap = new HashMap();

            ps = con.prepareStatement(parseSQL(sql, seqMap));

            setNamedParams(ps, params, seqMap);

            rs = ps.executeQuery();
            if (rs.next()) {
                res = new String(rs.getString(1));
            }
        } catch (SQLException e) {
            logger.error("SQLException: [" + sql + "]", e);
            throw e;
        } catch (HandleException e) {
            logger.error("HandleException: [" + sql + "]", e);
            throw e;
        } finally {
            releaseResources(ps, rs);
        }
        return res;
    }

    public BigDecimal findForBigDecimal(Connection con, String sql, Map<String, Object> params)
            throws SQLException, HandleException {
        if ((con == null) || (sql == null) || (sql.trim().length() <= 0)) {
            return null;
        }
        if ((this.sqlLogFlag) || (BaseVariables.global_sql_log_flag)) {
            logger.info(logHeader + sql);
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        BigDecimal res = null;
        try {
            Map<Integer, String> seqMap = new HashMap();

            ps = con.prepareStatement(parseSQL(sql, seqMap));

            setNamedParams(ps, params, seqMap);

            rs = ps.executeQuery();
            if (rs.next()) {
                res = rs.getBigDecimal(1);
            }
        } catch (SQLException e) {
            logger.error("SQLException: [" + sql + "]", e);
            throw e;
        } catch (HandleException e) {
            logger.error("HandleException: [" + sql + "]", e);
            throw e;
        } finally {
            releaseResources(ps, rs);
        }
        return res;
    }

    public Date findForDate(Connection con, String sql, Map<String, Object> params)
            throws SQLException, HandleException {
        if ((con == null) || (sql == null) || (sql.trim().length() <= 0)) {
            return null;
        }
        if ((this.sqlLogFlag) || (BaseVariables.global_sql_log_flag)) {
            logger.info(logHeader + sql);
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        Date res = null;
        try {
            Map<Integer, String> seqMap = new HashMap();

            ps = con.prepareStatement(parseSQL(sql, seqMap));

            setNamedParams(ps, params, seqMap);

            rs = ps.executeQuery();
            if (rs.next()) {
                Timestamp timestamp = rs.getTimestamp(1);
                if (timestamp != null) {
                    res = new Date(timestamp.getTime());
                }
            }
        } catch (SQLException e) {
            logger.error("SQLException: [" + sql + "]", e);
            throw e;
        } catch (HandleException e) {
            logger.error("HandleException: [" + sql + "]", e);
            throw e;
        } finally {
            releaseResources(ps, rs);
        }
        return res;
    }

    public Long generateSequenceByFieldName(Connection con, String fieldName)
            throws SQLException, HandleException, NoSuchFieldException, SecurityException {
        String sequenceName = MappingConvertor.getSequenceName(this.entityClass, fieldName);
        return generateSequence(con, sequenceName);
    }

    public Long generateSequence(Connection con, String sequenceName)
            throws SQLException, HandleException {
        if ((con == null) || (sequenceName == null) || (sequenceName.length() <= 0)) {
            return null;
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        Long sequenceValue = null;
        String sql = getDialect(con).getSequenceString(sequenceName);
        if ((this.sqlLogFlag) || (BaseVariables.global_sql_log_flag)) {
            logger.info(logHeader + sql);
        }
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                sequenceValue = new Long(rs.getLong(1));
            }
        } catch (SQLException e) {
            logger.error("SQLException: [" + sql + "]", e);
            throw e;
        } finally {
            releaseResources(ps, rs);
        }
        return sequenceValue;
    }

    public Dialect getDialect(Connection con)
            throws SQLException {
        return DialectHelper.getDialect(con);
    }

    public int[] batchBySeqParams(Connection con, String sql, List<List<Object>> params)
            throws SQLException, HandleException {
        if ((sql == null) || (sql.trim().length() <= 0) || (params == null)) {
            return null;
        }
        if ((this.sqlLogFlag) || (BaseVariables.global_sql_log_flag)) {
            logger.info(logHeader + sql);
        }
        PreparedStatement ps = null;
        int[] rows = null;
        int paramsLen = params.size();
        int objectLen = 0;
        List<Object> list = null;
        try {
            ps = con.prepareStatement(sql);
            for (int i = 0; i < paramsLen; i++) {
                list = (List) params.get(i);
                if ((list != null) && ((objectLen = list.size()) > 0)) {
                    for (int j = 0; j < objectLen; j++) {
                        Object obj = list.get(j);
                        setParamValue(ps, j + 1, obj);
                    }
                }
                ps.addBatch();
            }
            rows = ps.executeBatch();
        } catch (SQLException e) {
            logger.error("SQLException: [" + sql + "]", e);
            throw e;
        } catch (HandleException e) {
            logger.error("HandleException: [" + sql + "]", e);
            throw e;
        } finally {
            releaseResources(ps, null);
        }
        return rows;
    }

    public int[] batchByNameParams(Connection con, String sql, List<Map<String, Object>> params)
            throws SQLException, HandleException {
        if ((sql == null) || (sql.trim().length() <= 0) || (params == null)) {
            return null;
        }
        if ((this.sqlLogFlag) || (BaseVariables.global_sql_log_flag)) {
            logger.info(logHeader + sql);
        }
        PreparedStatement ps = null;
        int[] rows = null;
        int paramsLen = params.size();
        Map<String, Object> map = null;
        try {
            Map<Integer, String> seqMap = new HashMap();

            ps = con.prepareStatement(parseSQL(sql, seqMap));
            for (int i = 0; i < paramsLen; i++) {
                map = (Map) params.get(i);

                setNamedParams(ps, map, seqMap);

                ps.addBatch();
            }
            rows = ps.executeBatch();
        } catch (SQLException e) {
            logger.error("SQLException: [" + sql + "]", e);
            throw e;
        } catch (HandleException e) {
            logger.error("HandleException: [" + sql + "]", e);
            throw e;
        } finally {
            releaseResources(ps, null);
        }
        return rows;
    }

    private final void setParamsValue(PreparedStatement ps, List<Object> list)
            throws SQLException, HandleException {
        if ((ps == null) || (list == null) || (list.size() <= 0)) {
            return;
        }
        int i = 0;
        for (int paramsLen = list.size(); i < paramsLen; i++) {
            setParamValue(ps, i + 1, list.get(i));
        }
    }

    private final void setParamValue(PreparedStatement ps, int count, Object object)
            throws SQLException, HandleException {
        if (ps == null) {
            return;
        }
        if (object == null) {
            ps.setObject(count, object);
            return;
        }
        if ((object instanceof byte[])) {
            ps.setBytes(count, (byte[]) object);
        } else if ((object instanceof Integer)) {
            ps.setInt(count, ((Integer) object).intValue());
        } else if ((object instanceof Long)) {
            ps.setLong(count, ((Long) object).longValue());
        } else if ((object instanceof Float)) {
            ps.setFloat(count, ((Float) object).floatValue());
        } else if ((object instanceof Double)) {
            ps.setDouble(count, ((Double) object).doubleValue());
        } else if ((object instanceof BigDecimal)) {
            ps.setBigDecimal(count, (BigDecimal) object);
        } else if ((object instanceof String)) {
            ps.setString(count, (String) object);
        } else if ((object instanceof Date)) {
            ps.setTimestamp(count, new Timestamp(((Date) object).getTime()));
        } else {
            ps.setObject(count, object);
        }
    }

    protected final void setParamValue(PreparedStatement ps, Class<?> clazz, int count, String columnName, Object object)
            throws SQLException, Exception {
        if ((ps == null) || (columnName == null) || (columnName.length() <= 0) || (clazz == null)) {
            return;
        }
        String classType = clazz.getDeclaredField(columnName).getType().getSimpleName();
        if (classType.equals("byte[]")) {
            if (object != null) {
                ps.setBytes(count, (byte[]) object);
            } else {
                ps.setNull(count, -2);
            }
        } else if (classType.equals("Integer")) {
            if (object != null) {
                ps.setInt(count, ((Integer) object).intValue());
            } else {
                ps.setNull(count, 4);
            }
        } else if (classType.equals("Long")) {
            if (object != null) {
                ps.setLong(count, ((Long) object).longValue());
            } else {
                ps.setNull(count, 4);
            }
        } else if (classType.equals("Float")) {
            if (object != null) {
                ps.setFloat(count, ((Float) object).floatValue());
            } else {
                ps.setNull(count, 6);
            }
        } else if (classType.equals("Double")) {
            if (object != null) {
                ps.setDouble(count, ((Double) object).doubleValue());
            } else {
                ps.setNull(count, 8);
            }
        } else if (classType.equals("BigDecimal")) {
            if (object != null) {
                ps.setBigDecimal(count, (BigDecimal) object);
            } else {
                ps.setNull(count, 2);
            }
        } else if (classType.equals("String")) {
            if (object != null) {
                ps.setString(count, (String) object);
            } else {
                ps.setString(count, null);
            }
        } else if (classType.equals("Date")) {
            if (object != null) {
                ps.setTimestamp(count, new Timestamp(((Date) object).getTime()));
            } else {
                ps.setDate(count, null);
            }
        } else {
            ps.setObject(count, object);
        }
    }

    private final Object getFieldValue(ResultSet rs, Class<?> clazz, int count, String variableName)
            throws SQLException, Exception {
        if ((rs == null) || (variableName == null) || (variableName.length() <= 0) || (clazz == null)) {
            return null;
        }
        Object fieldValue = null;
        if (variableName != null) {
            if ("rownum".equals(variableName)) {
                fieldValue = new Long(rs.getLong(count));
            } else if ("rownum_".equals(variableName)) {
                fieldValue = new Long(rs.getLong(count));
            } else if ("count_".equals(variableName)) {
                fieldValue = new Long(rs.getLong(count));
            } else {
                String classType = clazz.getDeclaredField(variableName).getType().getSimpleName();
                if (classType.equals("byte[]")) {
                    fieldValue = rs.getBytes(count);
                } else if (classType.equals("Integer")) {
                    fieldValue = new Integer(rs.getInt(count));
                } else if (classType.equals("Long")) {
                    fieldValue = new Long(rs.getLong(count));
                } else if (classType.equals("Float")) {
                    fieldValue = Float.valueOf(rs.getFloat(count));
                } else if (classType.equals("Double")) {
                    fieldValue = Double.valueOf(rs.getDouble(count));
                } else if (classType.equals("BigDecimal")) {
                    fieldValue = rs.getBigDecimal(count);
                } else if (classType.equals("String")) {
                    fieldValue = rs.getString(count);
                } else if (classType.equals("Date")) {
                    Timestamp timestamp = rs.getTimestamp(count);
                    if (timestamp != null) {
                        fieldValue = new Date(timestamp.getTime());
                    }
                } else {
                    fieldValue = rs.getString(count);
                }
            }
        }
        return fieldValue;
    }

    private final String parseSQL(String sql, Map<Integer, String> seqMap) {
        if ((sql == null) || (sql.trim().length() <= 0)) {
            return sql;
        }
        String regex = "(:(\\w+))";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(sql);

        int idx = 1;
        while (m.find()) {
            seqMap.put(new Integer(idx++), m.group(2));
        }
        return sql.replaceAll(regex, "?");
    }

    private final void setNamedParams(PreparedStatement ps, Map<String, Object> paramMap, Map<Integer, String> seqMap)
            throws SQLException, HandleException {
        if ((ps == null) || (paramMap == null) || (paramMap.size() <= 0) || (seqMap == null) || (seqMap.size() <= 0)) {
            return;
        }
        for (Iterator<Integer> iterator = seqMap.keySet().iterator(); iterator.hasNext(); ) {
            Integer key = (Integer) iterator.next();
            Object value = seqMap.get(key);

            setParamValue(ps, key.intValue(), paramMap.get(value));
        }
    }

    private final List<E> convertToEitity(ResultSet rs)
            throws SQLException, HandleException {
        ResultSetMetaData rsm = rs.getMetaData();
        List<E> resultList = new ArrayList();
        E vo = null;
        try {
            while (rs.next()) {
                vo = this.entityClass.newInstance();
                for (int i = 1; i <= rsm.getColumnCount(); i++) {
                    String variableName = MappingConvertor.toVariableName(rsm.getColumnName(i).toLowerCase());
                    Object variableValue = getFieldValue(rs, this.entityClass, i, variableName);

                    String methodName = MappingConvertor.toSetMethodName(variableName);
                    Method method = this.entityClass.getMethod(methodName, new Class[]{this.entityClass.getDeclaredField(variableName).getType()});
                    method.invoke(vo, new Object[]{variableValue});
                }
                resultList.add(vo);
            }
        } catch (Exception e) {
            logger.info("Exception: ", e);
            throw new HandleException("-110001", "数据实体转换异常");
        }
        return resultList;
    }

    private final List<Map<?, ?>> convertToMap(ResultSet rs)
            throws SQLException, HandleException {
        ResultSetMetaData rsm = rs.getMetaData();

        List<Map<?, ?>> resultList = new ArrayList();

        Map<Object, Object> entity = null;
        try {
            while (rs.next()) {
                entity = new HashMap();
                for (int i = 1; i <= rsm.getColumnCount(); i++) {
                    String variableName = MappingConvertor.toVariableName(rsm.getColumnName(i).toLowerCase());
                    entity.put(variableName, rs.getObject(i));
                }
                resultList.add(entity);
            }
        } catch (Exception e) {
            logger.info("Exception: ", e);
            throw new HandleException("-110001", "数据实体转换异常");
        }
        return resultList;
    }

    private static final void releaseResources(PreparedStatement ps, ResultSet rs)
            throws SQLException, HandleException {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            logger.error("[BaseGenericDAO:{}] PreparedStatement close error", e.getStackTrace()[1].getMethodName());
            throw e;
        }
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            logger.error("[BaseGenericDAO:{}] ResultSet close error", e.getStackTrace()[1].getMethodName());
            throw e;
        }
    }
}
