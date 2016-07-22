package com.pro.test.web.dao;

import com.pro.test.core.common.mybatis.dao.GenericDAO;
import com.pro.test.web.dao.mapper.TbHxpRefCommentMapper;
import com.pro.test.web.entity.TbHxpRefComment;
import org.springframework.stereotype.Repository;

/**
 * Created by hxpeng on 2016/7/5.
 */

@Repository
public class TbHxpRefCommentDao extends GenericDAO<TbHxpRefComment, TbHxpRefCommentMapper> {


    public String test(){
        mapper.selectByPrimaryKey("111");
        return "";
    }



}
