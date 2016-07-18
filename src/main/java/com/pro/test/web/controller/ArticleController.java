package com.pro.test.web.controller;

import com.pro.test.core.common.springmvc.entity.RequestResolver;
import com.pro.test.web.admin.entity.TbHxpArticle;
import com.pro.test.web.admin.service.TbHxpArticleManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by hxpeng on 2016/7/6.
 */
@Controller
@RequestMapping(value = "/article")
public class ArticleController {

    @Resource
    private TbHxpArticleManager tbHxpArticleManager;


    @RequestMapping(value = "articleDetail.html")
    public String addArticle(RequestResolver requestResolver, TbHxpArticle tbHxpArticle){

        System.out.print("111111");
        tbHxpArticleManager.insertArticle(tbHxpArticle);
        return "article/articleDetail";

    }


}
