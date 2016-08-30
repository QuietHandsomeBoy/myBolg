package com.pro.test.web.dao;

import com.pro.test.core.common.mybatis.dao.GenericDAO;
import com.pro.test.web.dao.mapper.TbHxpArticleContentMapper;
import com.pro.test.web.entity.TbHxpArticleContent;
import org.springframework.stereotype.Repository;

/**
 * Created by hxpeng on 2016/7/5.
 */

@Repository
public class TbHxpArticleContentDao extends GenericDAO<TbHxpArticleContent, TbHxpArticleContentMapper> {


    public String test() {
        return "";
    }

    public int update(TbHxpArticleContent tbHxpArticleContent) {
        return this.mapper.updateByArticleIdSelective(tbHxpArticleContent);
    }

    public TbHxpArticleContent findOneByArticleId(String articleId) {
        return this.mapper.findOneByArticleId(articleId);
    }

}
