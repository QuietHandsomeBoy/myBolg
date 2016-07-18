package com.pro.test.web.admin.service;

import com.pro.test.core.common.mybatis.service.SimpleManager;
import com.pro.test.web.admin.dao.TbHxpArticleContentDao;
import com.pro.test.web.admin.entity.TbHxpArticleContent;
import org.springframework.stereotype.Service;


/**
 * Created by hxpeng on 2016/7/1.
 */
@Service
public class TbHxpArticleContentManager extends SimpleManager<TbHxpArticleContent, TbHxpArticleContentDao> {


    public String test(){
        dao.findAll();
        return "";
    }
}
