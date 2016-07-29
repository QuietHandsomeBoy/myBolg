package com.pro.test.web.dao.mapper;

import com.pro.test.core.common.mybatis.dao.GenericMapper;
import com.pro.test.web.entity.TbHxpComment;
import java.util.List;

public interface TbHxpCommentMapper extends GenericMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbHxpComment record);

    TbHxpComment selectByPrimaryKey(String id);

    List<TbHxpComment> selectAll();

    int updateByPrimaryKey(TbHxpComment record);
}