package com.pro.test.web.dao.mapper;

import com.pro.test.core.common.mybatis.dao.GenericMapper;
import com.pro.test.web.entity.TbHxpRefComment;

public interface TbHxpRefCommentMapper extends GenericMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbHxpRefComment record);

    int insertSelective(TbHxpRefComment record);

    TbHxpRefComment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbHxpRefComment record);

    int updateByPrimaryKey(TbHxpRefComment record);
}