package com.pro.test.web.dao.mapper;

import com.pro.test.core.common.mybatis.dao.GenericMapper;
import com.pro.test.web.entity.TbHxpArticleContent;
import org.apache.ibatis.annotations.Param;

public interface TbHxpArticleContentMapper extends GenericMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbHxpArticleContent record);

    int insertSelective(TbHxpArticleContent record);

    TbHxpArticleContent selectByPrimaryKey(String id);

    int updateByArticleIdSelective(TbHxpArticleContent record);

    int updateByPrimaryKeyWithBLOBs(TbHxpArticleContent record);

    int updateByPrimaryKey(TbHxpArticleContent record);

    TbHxpArticleContent findOneByArticleId(@Param(value = "articleId") String articleId);
}