package com.pro.test.web.dao.mapper;

import com.pro.test.core.common.mybatis.dao.GenericMapper;
import com.pro.test.web.entity.TbHxpArticleContent;
import java.util.List;

public interface TbHxpArticleContentMapper extends GenericMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbHxpArticleContent record);

    TbHxpArticleContent selectByPrimaryKey(String id);

    List<TbHxpArticleContent> selectAll();

    int updateByPrimaryKey(TbHxpArticleContent record);
}