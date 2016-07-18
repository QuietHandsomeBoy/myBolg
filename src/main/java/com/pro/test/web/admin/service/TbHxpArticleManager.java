package com.pro.test.web.admin.service;

import com.pro.test.core.common.mybatis.service.SimpleManager;
import com.pro.test.web.admin.dao.TbHxpArticleDao;
import com.pro.test.web.admin.entity.TbHxpArticle;
import org.springframework.stereotype.Service;

/**
 * Created by hxpeng on 2016/7/1.
 */
@Service
public class TbHxpArticleManager extends SimpleManager<TbHxpArticle, TbHxpArticleDao> {


    public TbHxpArticle findOneById(String id){
        return dao.selectByPrimaryKey(id);
    }


    public int insertArticle(TbHxpArticle tbHxpArticle){
        return dao.insert(tbHxpArticle);
    }

}
