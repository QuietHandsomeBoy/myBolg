package com.pro.test.core.common.mybatis.dao;

import com.pro.test.core.common.mybatis.ContextData;
import com.pro.test.core.common.mybatis.MappingConvertor;
import com.pro.test.core.common.mybatis.SqlParser;
import com.pro.test.core.common.mybatis.dialect.Dialect;
import com.pro.test.core.common.mybatis.dialect.DialectHelper;
import com.pro.test.core.common.mybatis.entity.Pagination;
import org.apache.ibatis.mapping.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hxpeng on 2016/6/29.
 */
public abstract class GenericDAO<E, M extends GenericMapper>
        extends SqlSessionDaoSupport {


    private static final Logger logger = LoggerFactory.getLogger(GenericDAO.class);
    public static boolean APP_SQL_LOG = false;
    protected String tableName;
    protected M mapper;
    protected static final int SQL_TYPE_INSERT = 1;
    protected static final int SQL_TYPE_UPDATE = 2;
    protected static final int SQL_TYPE_DELETE = 3;
    protected static final String SQL_METHOD_ADD = "add";
    protected static final String SQL_METHOD_UPDATE = "update";
    protected static final String SQL_METHOD_DELETE = "delete";
    protected static final String SQL_METHOD_FIND_PAGE = "findPage";
    protected Class<E> entityClass;
    protected Class<M> mapperClass;
    protected BaseDAO<E> baseDAO;


    public GenericDAO()
    {
        //getGenericSuperclass()返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type
        //getActualTypeArguments()返回表示此类型实际类型参数的 Type 对象的数组。
        Type[] types = ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments();

        //获取实体类
        this.entityClass = ((Class)types[0]);
        //获取mapper
        this.mapperClass = ((Class)types[1]);
        //获取表名
        this.tableName = MappingConvertor.toTableName(this.entityClass.getSimpleName());

        this.baseDAO = new BaseDAO(this.entityClass);
    }

    @Autowired
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate)
    {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    public Connection getConnection()
    {
        return DataSourceUtils.getConnection(getSqlSession().getConfiguration().getEnvironment().getDataSource());
    }

    public Dialect getDialect()
    {
        return DialectHelper.getDialect(getConnection());
    }

    public M getMapper()
    {
        return this.mapper;
    }

    @Autowired
    public void setMapper(M mapper)
    {
        this.mapper = mapper;
    }

    public List<E> findAll()
    {
        return this.mapper.findAll();
    }

    public E selectByPrimaryKey(Object id)
    {
        if (id == null) {
            return null;
        }
        return (E)this.mapper.selectByPrimaryKey(id);
    }

    public List<E> findByIds(List<Object> ids)
    {
        if (ids == null) {
            return null;
        }
        return this.mapper.findByIds(ids);
    }

    public List<E> findList(E entity)
    {
        if (entity == null) {
            return null;
        }
        return this.mapper.findList(entity);
    }

    public List<E> findList(ContextData data)
    {
        if (data == null) {
            return null;
        }
        return this.mapper.findList(data);
    }

    public List<E> findPage(ContextData contextData)
    {
        if (contextData == null) {
            return findList(contextData);
        }
        Pagination pagination = contextData.getPagination();

        int limit = pagination == null ? 0 : pagination.getPageSize();
        int offset = pagination == null ? 10 : pagination.getCurrentPageStartRecord() - 1;

        return getSqlSession().selectList(this.mapperClass.getName() + "." + "findPage", contextData, new RowBounds(limit, offset));
    }

    public long findPageCount(ContextData contextData)
    {
        return findCount("findPage", contextData);
    }

    public int insert(E entity)
    {
        if (entity == null) {
            return 0;
        }
        return this.mapper.insert(entity);
    }

    public int update(E entity)
    {
        if (entity == null) {
            return 0;
        }
        return this.mapper.update(entity);
    }

    public int update(ContextData data)
    {
        if (data == null) {
            return 0;
        }
        return this.mapper.update(data);
    }

    public int deleteByPrimaryKey(Object id)
    {
        if (id == null) {
            return 0;
        }
        return this.mapper.deleteByPrimaryKey(id);
    }

    public int deleteByIds(List<String> ids)
    {
        if (ids == null) {
            return 0;
        }
        return this.mapper.deleteByIds(ids);
    }

    public int delete(E entity)
    {
        if (entity == null) {
            return 0;
        }
        return this.mapper.delete(entity);
    }

    public int delete(ContextData data)
    {
        if (data == null) {
            return 0;
        }
        return this.mapper.delete(data);
    }

    public Long generateSequence(String sequenceName)
    {
        return generateSequence(sequenceName, false);
    }

    public Long generateSequence(String sequenceName, boolean autoFlag)
    {
        try
        {
            return this.baseDAO.generateSequence(getConnection(), sequenceName);
        }
        catch (Exception e)
        {
            logger.info("Exception: ", e);
        }
        return null;
    }

    public Long generateSequenceBySql(String sql)
    {
        try
        {
            return this.baseDAO.generateSequence(getConnection(), sql);
        }
        catch (Exception e)
        {
            logger.info("Exception: ", e);
        }
        return null;
    }

    public long findCount(String methodName, ContextData contentData)
    {
        Configuration configuration = getSqlSession().getConfiguration();
        BoundSql boundSql = configuration.getMappedStatement(this.mapperClass.getName() + "." + methodName).getBoundSql(contentData);
        String sql = SqlParser.getCountSql(getDialect(), boundSql.getSql());

        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        List<Object> params = new ArrayList();
        if (parameterMappings != null)
        {
            TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
            MetaObject metaObject = contentData == null ? null : configuration.newMetaObject(contentData);

            int i = 0;
            for (int len = parameterMappings.size(); i < len; i++)
            {
                ParameterMapping parameterMapping = (ParameterMapping)parameterMappings.get(i);
                if (parameterMapping.getMode() != ParameterMode.OUT)
                {
                    Object value = null;
                    String propertyName = parameterMapping.getProperty();
                    PropertyTokenizer prop = new PropertyTokenizer(propertyName);
                    if (contentData == null)
                    {
                        value = null;
                    }
                    else if (typeHandlerRegistry.hasTypeHandler(contentData.getClass()))
                    {
                        value = contentData;
                    }
                    else if (boundSql.hasAdditionalParameter(propertyName))
                    {
                        value = boundSql.getAdditionalParameter(propertyName);
                    }
                    else if ((propertyName.startsWith("__frch_")) && (boundSql.hasAdditionalParameter(prop.getName())))
                    {
                        value = boundSql.getAdditionalParameter(prop.getName());
                        if (value != null) {
                            value = configuration.newMetaObject(value).getValue(propertyName.substring(prop.getName().length()));
                        }
                    }
                    else
                    {
                        value = metaObject == null ? null : metaObject.getValue(propertyName);
                    }
                    params.add(value);
                }
            }
        }
        try
        {
            return this.baseDAO.findForLong(getConnection(), sql, params).longValue();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return 0L;
    }

    public E findByIdByJDBC(Object id)
            throws Exception
    {
        if (id == null) {
            return null;
        }
        List<Object> params = new ArrayList();

        String idConditionItem = MappingConvertor.toIdConditionItem(this.entityClass, id, params);
        String sql = "select " + MappingConvertor.toSelectItem(this.entityClass) + " from " + this.tableName + idConditionItem;

        return (E)this.baseDAO.findUnique(getConnection(), sql, params);
    }

    public Map<?, ?> findByIdForMapByJDBC(Object id)
            throws Exception
    {
        if (id == null) {
            return null;
        }
        List<Object> params = new ArrayList();

        String idConditionItem = MappingConvertor.toIdConditionItem(this.entityClass, id, params);
        String sql = "select " + MappingConvertor.toSelectItem(this.entityClass) + " from " + this.tableName + idConditionItem;

        return this.baseDAO.findUniqueForMap(getConnection(), sql, params);
    }

    public List<E> findByIdsByJDBC(List<Object> idList)
            throws Exception
    {
        if ((idList == null) || (idList.size() <= 0)) {
            return null;
        }
        List<Object> params = new ArrayList();

        String idConditionItem = MappingConvertor.toIdConditionItem(this.entityClass, idList, params);
        String sql = "select " + MappingConvertor.toSelectItem(this.entityClass) + " from " + this.tableName + idConditionItem;

        return this.baseDAO.findList(getConnection(), sql, params);
    }

    public List<Map<?, ?>> findByIdsForMapByJDBC(List<Object> idList)
            throws Exception
    {
        if ((idList == null) || (idList.size() <= 0)) {
            return null;
        }
        List<Object> params = new ArrayList();

        String idConditionItem = MappingConvertor.toIdConditionItem(this.entityClass, idList, params);
        String sql = "select " + MappingConvertor.toSelectItem(this.entityClass) + " from " + this.tableName + idConditionItem;

        return this.baseDAO.findListForMap(getConnection(), sql, params);
    }

    public List<E> findAllByJDBC()
            throws Exception
    {
        String sql = "select " + MappingConvertor.toSelectItem(this.entityClass) + " from " + this.tableName;

        return this.baseDAO.findList(getConnection(), sql, new ArrayList());
    }

    public List<Map<?, ?>> findAllForMapByJDBC()
            throws Exception
    {
        String sql = "select " + MappingConvertor.toSelectItem(this.entityClass) + " from " + this.tableName;

        return this.baseDAO.findListForMap(getConnection(), sql, new ArrayList());
    }

    public E findUniqueByJDBC(Map<String, Object> data)
            throws Exception
    {
        List<Object> params = new ArrayList();

        String conditionItem = MappingConvertor.toConditionItem(data, params);
        String sql = "select " + MappingConvertor.toSelectItem(this.entityClass) + " from " + this.tableName + conditionItem;

        return (E)this.baseDAO.findUnique(getConnection(), sql, params);
    }

    public Map<?, ?> findUniqueForMapByJDBC(Map<String, Object> data)
            throws Exception
    {
        List<Object> params = new ArrayList();

        String conditionItem = MappingConvertor.toConditionItem(data, params);
        String sql = "select " + MappingConvertor.toSelectItem(this.entityClass) + " from " + this.tableName + conditionItem;

        return this.baseDAO.findUniqueForMap(getConnection(), sql, params);
    }

    public List<E> findListByJDBC(Map<String, Object> data)
            throws Exception
    {
        List<Object> params = new ArrayList();

        String conditionItem = MappingConvertor.toConditionItem(data, params);
        String sql = "select " + MappingConvertor.toSelectItem(this.entityClass) + " from " + this.tableName + conditionItem;

        return this.baseDAO.findList(getConnection(), sql, params);
    }

    public List<Map<?, ?>> findListForMapByJDBC(Map<String, Object> data)
            throws Exception
    {
        List<Object> params = new ArrayList();

        String conditionItem = MappingConvertor.toConditionItem(data, params);
        String sql = "select " + MappingConvertor.toSelectItem(this.entityClass) + " from " + this.tableName + conditionItem;

        return this.baseDAO.findListForMap(getConnection(), sql, params);
    }

    public List<E> findListByJDBC(Map<String, Object> data, int offset, int limit)
            throws Exception
    {
        List<Object> params = new ArrayList();

        String conditionItem = MappingConvertor.toConditionItem(data, params);
        String sql = "select " + MappingConvertor.toSelectItem(this.entityClass) + " from " + this.tableName + conditionItem;

        return this.baseDAO.findList(getConnection(), sql, params, offset, limit);
    }

    public List<Map<?, ?>> findListForMapByJDBC(Map<String, Object> data, int begin, int end)
            throws Exception
    {
        List<Object> params = new ArrayList();

        String conditionItem = MappingConvertor.toConditionItem(data, params);
        String sql = "select " + MappingConvertor.toSelectItem(this.entityClass) + " from " + this.tableName + conditionItem;

        return this.baseDAO.findListForMap(getConnection(), sql, params);
    }

    public List<E> findListByPropertyByJDBC(String propertyName, Object propertyValue)
            throws Exception
    {
        if ((propertyName == null) || (propertyName.trim().length() <= 0)) {
            return null;
        }
        Map<String, Object> data = new HashMap();
        data.put(propertyName, propertyValue);

        return findListByJDBC(data);
    }

    public List<Map<?, ?>> findListByPropertyForMapByJDBC(String propertyName, Object propertyValue)
            throws Exception
    {
        if ((propertyName == null) || (propertyName.trim().length() <= 0)) {
            return null;
        }
        Map<String, Object> data = new HashMap();
        data.put(propertyName, propertyValue);

        return findListForMapByJDBC(data);
    }

    public List<E> findListByPropertyByJDBC(String propertyName, Object propertyValue, int begin, int end)
            throws Exception
    {
        if ((propertyName == null) || (propertyName.trim().length() <= 0)) {
            return null;
        }
        Map<String, Object> data = new HashMap();
        data.put(propertyName, propertyValue);

        return findListByJDBC(data, begin, end);
    }

    public List<Map<?, ?>> findListByPropertyForMapByJDBC(String propertyName, Object propertyValue, int begin, int end)
            throws Exception
    {
        if ((propertyName == null) || (propertyName.trim().length() <= 0)) {
            return null;
        }
        Map<String, Object> data = new HashMap();
        data.put(propertyName, propertyValue);

        return findListForMapByJDBC(data, begin, end);
    }

    public int addByJDBC(E entity)
            throws Exception
    {
        if (entity == null) {
            return 0;
        }
        List<Object> params = new ArrayList();

        String insertItem = MappingConvertor.toInsertItem(entity, params);
        String sql = "insert into " + this.tableName + insertItem;

        return this.baseDAO.save(getConnection(), sql, params);
    }

    public int updateByIdByJDBC(E entity, Object id)
            throws Exception
    {
        if (entity == null) {
            return 0;
        }
        List<Object> params = new ArrayList();

        String updateItem = MappingConvertor.toUpdateNotNullItem(entity, params);
        String conditionItem = MappingConvertor.toIdConditionItem(this.entityClass, id, params);
        String sql = "update " + this.tableName + " set " + updateItem + conditionItem;

        return this.baseDAO.save(getConnection(), sql, params);
    }

    public int updateByIdsByJDBC(E entity, List<Object> idList)
            throws Exception
    {
        if (entity == null) {
            return 0;
        }
        List<Object> params = new ArrayList();

        String updateItem = MappingConvertor.toUpdateNotNullItem(entity, params);
        String conditionItem = MappingConvertor.toIdConditionItem(this.entityClass, idList, params);
        String sql = "update " + this.tableName + " set " + updateItem + conditionItem;

        return this.baseDAO.save(getConnection(), sql, params);
    }

    public int updateByJDBC(E entity, Map<String, Object> data)
            throws Exception
    {
        if ((entity == null) || (data == null) || (data.size() <= 0)) {
            return 0;
        }
        List<Object> params = new ArrayList();

        String updateItem = MappingConvertor.toUpdateNotNullItem(entity, params);
        String conditionItem = MappingConvertor.toConditionItem(data, params);
        String sql = "update " + this.tableName + " set " + updateItem + conditionItem;

        return this.baseDAO.save(getConnection(), sql, params);
    }

    public int deleteByIdByJDBC(Object id)
            throws Exception
    {
        List<Object> params = new ArrayList();

        String idConditionItem = MappingConvertor.toIdConditionItem(this.entityClass, id, params);
        String sql = "delete from " + this.tableName + idConditionItem;

        return this.baseDAO.save(getConnection(), sql, params);
    }

    public int deleteByIdsByJDBC(List<Object> idList)
            throws Exception
    {
        if ((idList == null) || (idList.size() <= 0)) {
            return 0;
        }
        List<Object> params = new ArrayList();

        String conditionItem = MappingConvertor.toIdConditionItem(this.entityClass, idList, params);
        String sql = "delete from " + this.tableName + conditionItem;

        return this.baseDAO.save(getConnection(), sql, params);
    }

    public int deleteByJDBC(Map<String, Object> data)
            throws Exception
    {
        if ((data == null) || (data.size() <= 0)) {
            return 0;
        }
        List<Object> params = new ArrayList();

        String conditionItem = MappingConvertor.toConditionItem(data, params);
        String sql = "delete from " + this.tableName + conditionItem;

        return this.baseDAO.save(getConnection(), sql, params);
    }

    public int deleteAllByJDBC()
            throws Exception
    {
        String sql = "delete from " + this.tableName;

        return this.baseDAO.save(getConnection(), sql, new ArrayList());
    }

    public int[] batchAddByJDBC(List<E> list)
            throws Exception
    {
        if ((list == null) || (list.size() <= 0)) {
            return null;
        }
        List<List<Object>> params = new ArrayList();

        String batchInsertItem = MappingConvertor.toBatchInsertItem(this.entityClass, list, params);
        String sql = "insert into " + this.tableName + batchInsertItem;

        return this.baseDAO.batchBySeqParams(getConnection(), sql, params);
    }

    public int[] batchAddByJDBC(List<E> list, Map<String, Object> map)
            throws Exception
    {
        if ((list == null) || (list.size() <= 0)) {
            return null;
        }
        List<List<Object>> params = new ArrayList();

        String batchInsertItem = MappingConvertor.toBatchInsertCustomItem(this.entityClass, list, params, map);
        String sql = "insert into " + this.tableName + batchInsertItem;

        return this.baseDAO.batchBySeqParams(getConnection(), sql, params);
    }
}