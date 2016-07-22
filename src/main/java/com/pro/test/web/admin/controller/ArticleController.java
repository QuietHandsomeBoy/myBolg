package com.pro.test.web.admin.controller;

import com.pro.test.core.validator.ArticleValidator;
import com.pro.test.core.enumdata.ArticleStatus;
import com.pro.test.core.util.UUIDUtils;
import com.pro.test.web.entity.TbHxpArticle;
import com.pro.test.web.admin.service.TbHxpArticleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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
        return "admin/article/articleList";
    }

    @RequestMapping(value = "insertArticle.html")
    public String insertArticle(){
        return "admin/article/insertArticle";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new ArticleValidator());
    }


    @RequestMapping(value = "/saveArticle", method = RequestMethod.POST)
    public String saveArticle(@Validated TbHxpArticle tbHxpArticle, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return "admin/article/insertArticle";
        }

        tbHxpArticle.setArticleStatus(ArticleStatus.Draft.getKey());
        tbHxpArticle.setArticleId(UUIDUtils.getUUID());


        System.out.println("ArticleRange："+tbHxpArticle.getArticleRange());
        System.out.println("ArticleTags："+tbHxpArticle.getArticleTags());
        System.out.println("keyWords："+tbHxpArticle.getKeyWords());
        System.out.println("ArticleIntroduced："+tbHxpArticle.getArticleIntroduced());
        System.out.println("ArticleTitle："+tbHxpArticle.getArticleTitle().length());
//        System.out.println("ArticleContent："+articleContent);
        tbHxpArticleManager.insertArticle(tbHxpArticle);

        return "admin/article/articleList";
    }

}
