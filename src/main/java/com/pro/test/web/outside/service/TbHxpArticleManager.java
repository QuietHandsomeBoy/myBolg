package com.pro.test.web.outside.service;

import com.pro.test.core.common.mybatis.service.SimpleManager;
import com.pro.test.web.dao.TbHxpArticleDao;
import com.pro.test.web.entity.TbHxpArticle;
import org.springframework.stereotype.Service;

/**
 * Created by hxpeng on 2016/7/1.
 */
@Service(value = "outsideArticleManager")
public class TbHxpArticleManager extends SimpleManager<TbHxpArticle, TbHxpArticleDao> {

    public TbHxpArticle findOneById(String id){
        return dao.selectByPrimaryKey(id);
    }

    public TbHxpArticle findOneByArticleId(String articleId){
        return dao.findOneByArticleID(articleId);
    }



}
