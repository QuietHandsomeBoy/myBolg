package com.pro.test.web.admin.dao;

import com.pro.test.core.common.mybatis.dao.GenericDAO;
import com.pro.test.web.admin.dao.mapper.TbHxpArticleContentMapper;
import com.pro.test.web.admin.entity.TbHxpArticleContent;
import org.springframework.stereotype.Repository;

/**
 * Created by hxpeng on 2016/7/5.
 */

@Repository
public class TbHxpArticleContentDao extends GenericDAO<TbHxpArticleContent, TbHxpArticleContentMapper> {


    public String test(){
        return "";
    }



}
