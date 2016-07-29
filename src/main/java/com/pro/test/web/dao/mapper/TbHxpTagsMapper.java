package com.pro.test.web.dao.mapper;

import com.pro.test.core.common.mybatis.dao.GenericMapper;
import com.pro.test.web.entity.TbHxpTags;
import java.util.List;

public interface TbHxpTagsMapper extends GenericMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbHxpTags record);

    TbHxpTags selectByPrimaryKey(String id);

    List<TbHxpTags> selectAll();

    int updateByPrimaryKey(TbHxpTags record);
}