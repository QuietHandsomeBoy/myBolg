package com.pro.test.web.outside.controller;

import com.pro.test.core.common.springmvc.entity.RequestResolver;
import com.pro.test.core.enumdata.ArticleStatus;
import com.pro.test.web.entity.TbHxpArticleContent;
import com.pro.test.web.outside.service.TbHxpArticleContentManager;
import com.pro.test.web.entity.TbHxpArticle;
import com.pro.test.web.outside.service.TbHxpArticleManager;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hxpeng on 2016/7/6.
 */
@Controller
@RequestMapping(value = "/article")
public class ArticleController {

    @Autowired
    private TbHxpArticleManager tbHxpArticleManager;

    @Autowired
    private TbHxpArticleContentManager tbHxpArticleContentManager;


    @RequestMapping(value = "articleDetail/{articleId}.html")
    public String addArticle(@PathVariable String articleId, RequestResolver requestResolver) {

        if (StringUtils.isNotBlank(articleId)) {
            TbHxpArticle tbHxpArticle = tbHxpArticleManager.findOneByArticleId(articleId);
            if (tbHxpArticle != null && tbHxpArticle.getArticleStatus().equals(ArticleStatus.normal.getKey())) {
                requestResolver.setAttribute("tbHxpArticle", tbHxpArticle);
                TbHxpArticleContent tbHxpArticleContent = tbHxpArticleContentManager.findOneByArticleId(articleId);
                if(tbHxpArticleContent != null){
                    requestResolver.setAttribute("tbHxpArticleContent", tbHxpArticleContent);
                }
                return "outside/article/articleDetail";
            }
        }
        return "redirect:common/404";

    }


}
