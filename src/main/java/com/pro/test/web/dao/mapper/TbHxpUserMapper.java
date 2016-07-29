package com.pro.test.web.dao.mapper;

import com.pro.test.core.common.mybatis.dao.GenericMapper;
import com.pro.test.web.entity.TbHxpUser;
import java.util.List;

public interface TbHxpUserMapper extends GenericMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbHxpUser record);

    TbHxpUser selectByPrimaryKey(String id);

    List<TbHxpUser> selectAll();

    int updateByPrimaryKey(TbHxpUser record);
}