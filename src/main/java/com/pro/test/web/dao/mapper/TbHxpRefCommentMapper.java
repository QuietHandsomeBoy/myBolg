package com.pro.test.web.dao.mapper;

import com.pro.test.core.common.mybatis.dao.GenericMapper;
import com.pro.test.web.entity.TbHxpRefComment;
import java.util.List;

public interface TbHxpRefCommentMapper extends GenericMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbHxpRefComment record);

    TbHxpRefComment selectByPrimaryKey(String id);

    List<TbHxpRefComment> selectAll();

    int updateByPrimaryKey(TbHxpRefComment record);
}