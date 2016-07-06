package com.pro.test.core.common.mybatis.dao;

import com.pro.test.core.common.mybatis.ContextData;
import com.pro.test.core.common.mybatis.entity.Pagination;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * Created by hxpeng on 2016/6/29.
 */
public abstract interface GenericMapper{

    public abstract <E> List<E> findAll()
            throws DataAccessException;

    public abstract <E> E selectByPrimaryKey(Object paramObject)
            throws DataAccessException;

    public abstract <E> List<E> findByIds(List<Object> paramList)
            throws DataAccessException;

    public abstract <E> E findUnique(E paramE)
            throws DataAccessException;

    public abstract <E> E findUnique(ContextData paramContextData)
            throws DataAccessException;

    public abstract <E> List<E> findList(E paramE)
            throws DataAccessException;

    public abstract <E> List<E> findList(ContextData paramContextData)
            throws DataAccessException;

    public abstract <E> List<E> findPage(Pagination paramPagination, ContextData paramContextData, RowBounds paramRowBounds)
            throws DataAccessException;

    public abstract <E> int insert(E paramE)
            throws DataAccessException;

    public abstract <E> int update(E paramE)
            throws DataAccessException;

    public abstract int deleteByPrimaryKey(Object paramObject)
            throws DataAccessException;

    public abstract int deleteByIds(List<Object> paramList)
            throws DataAccessException;

    public abstract <E> int delete(E paramE)
            throws DataAccessException;

    public abstract int delete(ContextData paramContextData)
            throws DataAccessException;

    @Select({"${sql}"})
    public abstract Long generateSequence(@Param("sql") String paramString)
            throws DataAccessException;

}
