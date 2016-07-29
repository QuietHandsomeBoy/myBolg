package com.pro.test.web.dao.mapper;

import com.pro.test.core.common.mybatis.dao.GenericMapper;
import com.pro.test.web.entity.TbHxpUserLogin;
import java.util.List;

public interface TbHxpUserLoginMapper extends GenericMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbHxpUserLogin record);

    TbHxpUserLogin selectByPrimaryKey(String id);

    List<TbHxpUserLogin> selectAll();

    int updateByPrimaryKey(TbHxpUserLogin record);
}