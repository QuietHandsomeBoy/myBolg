package com.pro.test.web.dao.mapper;

import com.pro.test.core.common.mybatis.dao.GenericMapper;
import com.pro.test.web.entity.TbHxpArticle;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TbHxpArticleMapper extends GenericMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbHxpArticle record);

    int insertSelective(TbHxpArticle record);

    TbHxpArticle selectByPrimaryKey(String id);

    int updateByArticleIDSelective(TbHxpArticle record);

    int updateByPrimaryKey(TbHxpArticle record);

    List<Map<String,Object>> findArticleRangeCount();

    TbHxpArticle findOneByArticleId(@Param(value = "articleId") String articleId);

    int findAllCount();
}