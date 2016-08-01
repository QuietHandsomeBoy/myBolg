package com.pro.test.web.dao.mapper;

import com.pro.test.core.common.mybatis.dao.GenericMapper;
import com.pro.test.web.entity.TbHxpUserLogin;

public interface TbHxpUserLoginMapper extends GenericMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbHxpUserLogin record);

    int insertSelective(TbHxpUserLogin record);

    TbHxpUserLogin selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbHxpUserLogin record);

    int updateByPrimaryKey(TbHxpUserLogin record);
}