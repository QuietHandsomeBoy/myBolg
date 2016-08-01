package com.pro.test.web.dao.mapper;

import com.pro.test.core.common.mybatis.dao.GenericMapper;
import com.pro.test.web.entity.TbHxpComment;

public interface TbHxpCommentMapper extends GenericMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbHxpComment record);

    int insertSelective(TbHxpComment record);

    TbHxpComment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbHxpComment record);

    int updateByPrimaryKey(TbHxpComment record);
}