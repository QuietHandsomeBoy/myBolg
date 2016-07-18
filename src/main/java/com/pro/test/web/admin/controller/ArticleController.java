package com.pro.test.web.admin.controller;

import com.pro.test.web.admin.entity.TbHxpArticle;
import com.pro.test.web.admin.service.TbHxpArticleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hxpeng on 2016/7/14.
 */
@Controller("adminArticle")
@RequestMapping(value = "/admin/article")
public class ArticleController {

    @Autowired
    private TbHxpArticleManager tbHxpArticleManager;


    @RequestMapping(value = "articleList.html")
    public String articleList(){
        return "work/article/articleList";
    }

    @RequestMapping(value = "insertArticle.html")
    public String insertArticle(){
        return "work/article/insertArticle";
    }


    @RequestMapping(value = "/saveArticle")
    public String saveArticle(TbHxpArticle tbHxpArticle,String articleContent){

        System.out.println("ArticleRange："+tbHxpArticle.getArticleRange());
        System.out.println("ArticleTags："+tbHxpArticle.getArticleTags());
        System.out.println("keyWords："+tbHxpArticle.getKeyWords());
        System.out.println("ArticleIntroduced："+tbHxpArticle.getArticleIntroduced());
        System.out.println("ArticleTitle："+tbHxpArticle.getArticleTitle());
        System.out.println("ArticleContent："+articleContent);
        tbHxpArticle.setId("1351ADWADWA3AW");
        tbHxpArticle.setArticleId("1531DAWDA1");
        tbHxpArticleManager.insertArticle(tbHxpArticle);

        return "work/article/articleList";
    }

}
