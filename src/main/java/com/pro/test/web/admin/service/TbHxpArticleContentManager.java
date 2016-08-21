package com.pro.test.web.admin.service;

import com.pro.test.core.common.mybatis.service.SimpleManager;
import com.pro.test.web.dao.TbHxpArticleContentDao;
import com.pro.test.web.entity.TbHxpArticleContent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by hxpeng on 2016/7/1.
 */
@Service
public class TbHxpArticleContentManager extends SimpleManager<TbHxpArticleContent, TbHxpArticleContentDao> {


    public String test(){
        dao.findAll();
        return "";
    }

    @Transactional
    public int insert(TbHxpArticleContent tbHxpArticleContent){
        int i = 1/0;
        return this.dao.insert(tbHxpArticleContent);
    }
}
