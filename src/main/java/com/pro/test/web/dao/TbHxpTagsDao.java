package com.pro.test.web.dao;

import com.pro.test.core.common.mybatis.dao.GenericDAO;
import com.pro.test.web.dao.mapper.TbHxpTagsMapper;
import com.pro.test.web.entity.TbHxpTags;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hxpeng on 2016/7/5.
 */

@Repository
public class TbHxpTagsDao extends GenericDAO<TbHxpTags, TbHxpTagsMapper> {

    public List<TbHxpTags> findAllByCondition(TbHxpTags tbHxpTags) {
        return mapper.findAllByCondition(tbHxpTags);
    }

    public TbHxpTags findOneById(String id) {
        return mapper.selectByPrimaryKey(id);
    }
}
