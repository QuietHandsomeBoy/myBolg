package com.pro.test.web.dao.mapper;

import com.pro.test.core.common.mybatis.dao.GenericMapper;
import com.pro.test.web.entity.TbHxpArticle;

public interface TbHxpArticleMapper extends GenericMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbHxpArticle record);

    int insertSelective(TbHxpArticle record);

    TbHxpArticle selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbHxpArticle record);

    int updateByPrimaryKey(TbHxpArticle record);
}