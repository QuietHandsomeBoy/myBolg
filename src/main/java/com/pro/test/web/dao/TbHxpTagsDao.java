package com.pro.test.web.dao;

import com.pro.test.core.common.mybatis.dao.GenericDAO;
import com.pro.test.web.dao.mapper.TbHxpTagsMapper;
import com.pro.test.web.entity.TbHxpTags;
import org.springframework.stereotype.Repository;

/**
 * Created by hxpeng on 2016/7/5.
 */

@Repository
public class TbHxpTagsDao extends GenericDAO<TbHxpTags, TbHxpTagsMapper> {


    public String test(){
        mapper.selectByPrimaryKey("111");
        return "";
    }



}
