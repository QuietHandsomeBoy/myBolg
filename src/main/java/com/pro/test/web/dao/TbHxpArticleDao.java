package com.pro.test.web.dao;

import com.pro.test.core.common.mybatis.dao.GenericDAO;
import com.pro.test.web.dao.mapper.TbHxpArticleMapper;
import com.pro.test.web.entity.TbHxpArticle;
import org.springframework.stereotype.Repository;

/**
 * Created by hxpeng on 2016/7/5.
 */

@Repository
public class TbHxpArticleDao extends GenericDAO<TbHxpArticle, TbHxpArticleMapper> {

    public int insert(TbHxpArticle tbHxpArticle){
        return mapper.insert(tbHxpArticle);
    }

}
