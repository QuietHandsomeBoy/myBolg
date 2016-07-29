package com.pro.test.web.dao.mapper;

import com.pro.test.core.common.mybatis.dao.GenericMapper;
import com.pro.test.web.entity.TbHxpArticle;
import java.util.List;

public interface TbHxpArticleMapper extends GenericMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbHxpArticle record);

    TbHxpArticle selectByPrimaryKey(String id);

    List<TbHxpArticle> selectAll();

    int updateByPrimaryKey(TbHxpArticle record);

    List<TbHxpArticle> findPage();
}