package com.pro.test.web.dao.mapper;

import com.pro.test.core.common.mybatis.dao.GenericMapper;
import com.pro.test.web.entity.TbHxpUser;

public interface TbHxpUserMapper extends GenericMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbHxpUser record);

    int insertSelective(TbHxpUser record);

    TbHxpUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbHxpUser record);

    int updateByPrimaryKey(TbHxpUser record);
}