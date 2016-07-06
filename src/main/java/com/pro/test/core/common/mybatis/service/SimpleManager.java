package com.pro.test.core.common.mybatis.service;

import com.pro.test.core.common.annotation.Sequence;
import com.pro.test.core.common.mybatis.ContextData;
import com.pro.test.core.common.mybatis.dao.GenericDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;


/**
 * Created by hxpeng on 2016/7/5.
 */
public class SimpleManager<E, D extends GenericDAO<E, ?>>
{
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    protected D dao;

    public D getDao()
    {
        return this.dao;
    }

    @Autowired
    public void setDao(D dao)
    {
        this.dao = dao;
    }

    public List<E> findAll()
    {
        return this.dao.findAll();
    }

    public E selectByPrimaryKey(Object id)
    {
        if (id == null) {
            return null;
        }
        return (E)this.dao.selectByPrimaryKey(id);
    }

    public List<E> findByIds(List<Object> ids)
    {
        if (ids == null) {
            return null;
        }
        return this.dao.findByIds(ids);
    }

    public List<E> findList(E entity)
    {
        if (entity == null) {
            return null;
        }
        return this.dao.findList(entity);
    }

    public List<E> findList(ContextData condition)
    {
        if (condition == null) {
            return null;
        }
        return this.dao.findList(condition);
    }

    public List<E> findPage(ContextData contextData)
    {
        return this.dao.findPage(contextData);
    }

    public long findPageCount(ContextData contextData)
    {
        return this.dao.findPageCount(contextData);
    }

    public long findPageCount(String methodName, ContextData contextData)
    {
        return this.dao.findCount(methodName, contextData);
    }

    public int insert(E entity)
    {
        if (entity == null) {
            return 0;
        }
        return this.dao.insert(entity);
    }

    public int update(E entity)
    {
        if (entity == null) {
            return 0;
        }
        return this.dao.update(entity);
    }

    public int update(ContextData condition)
    {
        if (condition == null) {
            return 0;
        }
        return this.dao.update(condition);
    }

    public int deleteById(Object id)
    {
        if (id == null) {
            return 0;
        }
        return this.dao.deleteByPrimaryKey(id);
    }

    public int deleteByIds(List<Object> ids)
    {
        if (ids == null) {
            return 0;
        }
        return this.dao.deleteByIds(ids);
    }

    public int delete(E entity)
    {
        if (entity == null) {
            return 0;
        }
        return this.dao.delete(entity);
    }

    public int delete(ContextData condition)
    {
        if (condition == null) {
            return 0;
        }
        return this.dao.delete(condition);
    }

    public void fillSequence(Object object)
    {
        if (object == null) {
            return;
        }
        Class<?> objectClass = object.getClass();

        Field[] fields = objectClass.getDeclaredFields();
        if (fields == null) {
            return;
        }
        for (int i = 0; i < fields.length; i++)
        {
            Field field = fields[i];

            Sequence sequence = (Sequence)field.getAnnotation(Sequence.class);
            if (sequence != null)
            {
                Class<?> fieldClass = field.getType();
                if ((Integer.class.equals(fieldClass)) || (Long.class.equals(fieldClass)))
                {
                    String sequenceName = sequence.value();
                    boolean autoFlag = sequence.autoFlag();
                    Long sequenceValue = this.dao.generateSequence(sequenceName, autoFlag);

                    field.setAccessible(true);
                    try
                    {
                        if (Integer.class.equals(fieldClass)) {
                            field.set(object, new Integer(sequenceValue.intValue()));
                        } else if (Long.class.equals(fieldClass)) {
                            field.set(object, sequenceValue);
                        }
                    }
                    catch (Exception localException) {}
                }
            }
        }
    }

    public Long generateSequence(String sequenceName)
    {
        return this.dao.generateSequence(sequenceName);
    }

    public Long generateSequence(String sequenceName, boolean autoFlag)
    {
        return this.dao.generateSequence(sequenceName, autoFlag);
    }

    public E findByIdByJDBC(Object id)
            throws Exception
    {
        return (E)this.dao.findByIdByJDBC(id);
    }

    public Map<?, ?> findByIdForMapByJDBC(Object id)
            throws Exception
    {
        return this.dao.findByIdForMapByJDBC(id);
    }

    public List<E> findByIdsByJDBC(List<Object> idList)
            throws Exception
    {
        return this.dao.findByIdsByJDBC(idList);
    }

    public List<Map<?, ?>> findByIdsForMapByJDBC(List<Object> idList)
            throws Exception
    {
        return this.dao.findByIdsForMapByJDBC(idList);
    }

    public List<E> findAllByJDBC()
            throws Exception
    {
        return this.dao.findAllByJDBC();
    }

    public List<Map<?, ?>> findAllForMapByJDBC()
            throws Exception
    {
        return this.dao.findAllForMapByJDBC();
    }

    public E findUniqueByJDBC(Map<String, Object> condition)
            throws Exception
    {
        return (E)this.dao.findUniqueByJDBC(condition);
    }

    public Map<?, ?> findUniqueForMapByJDBC(Map<String, Object> condition)
            throws Exception
    {
        return this.dao.findUniqueForMapByJDBC(condition);
    }

    public List<E> findListByJDBC(Map<String, Object> condition)
            throws Exception
    {
        return this.dao.findListByJDBC(condition);
    }

    public List<Map<?, ?>> findListForMapByJDBC(Map<String, Object> condition)
            throws Exception
    {
        return this.dao.findListForMapByJDBC(condition);
    }

    public List<E> findListByJDBC(Map<String, Object> condition, int offset, int limit)
            throws Exception
    {
        return this.dao.findListByJDBC(condition, offset, limit);
    }

    public List<Map<?, ?>> findListForMapByJDBC(Map<String, Object> condition, int begin, int end)
            throws Exception
    {
        return this.dao.findListForMapByJDBC(condition, begin, end);
    }

    public List<E> findListByPropertyByJDBC(String propertyName, Object propertyValue)
            throws Exception
    {
        return this.dao.findListByPropertyByJDBC(propertyName, propertyValue);
    }

    public List<Map<?, ?>> findListByPropertyForMapByJDBC(String propertyName, Object propertyValue)
            throws Exception
    {
        return this.dao.findListByPropertyForMapByJDBC(propertyName, propertyValue);
    }

    public List<E> findListByPropertyByJDBC(String propertyName, Object propertyValue, int begin, int end)
            throws Exception
    {
        return this.dao.findListByPropertyByJDBC(propertyName, propertyValue, begin, end);
    }

    public List<Map<?, ?>> findListByPropertyForMapByJDBC(String propertyName, Object propertyValue, int begin, int end)
            throws Exception
    {
        return this.dao.findListByPropertyForMapByJDBC(propertyName, propertyValue, begin, end);
    }

    public int addByJDBC(E entity)
            throws Exception
    {
        return this.dao.addByJDBC(entity);
    }

    public int updateByIdByJDBC(E entity, Object id)
            throws Exception
    {
        return this.dao.updateByIdByJDBC(entity, id);
    }

    public int updateByIdsByJDBC(E entity, List<Object> idList)
            throws Exception
    {
        return this.dao.updateByIdsByJDBC(entity, idList);
    }

    public int updateByJDBC(E entity, Map<String, Object> condition)
            throws Exception
    {
        return this.dao.updateByJDBC(entity, condition);
    }

    public int deleteByIdByJDBC(Object id)
            throws Exception
    {
        return this.dao.deleteByIdByJDBC(id);
    }

    public int deleteByIdsByJDBC(List<Object> idList)
            throws Exception
    {
        return this.dao.deleteByIdsByJDBC(idList);
    }

    public int deleteByJDBC(Map<String, Object> condition)
            throws Exception
    {
        return this.dao.deleteByJDBC(condition);
    }

    public int deleteAllByJDBC()
            throws Exception
    {
        return this.dao.deleteAllByJDBC();
    }

    public int[] batchAddByJDBC(List<E> list)
            throws Exception
    {
        return this.dao.batchAddByJDBC(list);
    }

    public int[] batchAddByJDBC(List<E> list, Map<String, Object> map)
            throws Exception
    {
        return this.dao.batchAddByJDBC(list, map);
    }
}
