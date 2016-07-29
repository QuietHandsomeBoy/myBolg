package com.pro.test.web.admin.controller;

import com.pro.test.core.common.mybatis.ContextData;
import com.pro.test.core.common.mybatis.entity.Pagination;
import com.pro.test.core.common.springmvc.entity.RequestResolver;
import com.pro.test.core.controller.BaseController;
import com.pro.test.core.enumdata.ArticleStatus;
import com.pro.test.core.util.UUIDUtils;
import com.pro.test.web.admin.service.TbHxpArticleManager;
import com.pro.test.web.entity.TbHxpArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 * Created by hxpeng on 2016/7/14.
 */
@Controller("adminArticle")
@RequestMapping(value = "/admin/article")
public class ArticleController extends BaseController {

    @Autowired
    private TbHxpArticleManager tbHxpArticleManager;


    @RequestMapping(value = "articleList.html")
    public String articleList(RequestResolver requestResolver,Pagination pagination){
        pagination = new Pagination();
        pagination.setPageSize(20);
        ContextData contextData = new ContextData(pagination);

        TbHxpArticle tbHxpArticle = new TbHxpArticle();
        tbHxpArticle.setArticleTitle("测试");
        contextData.setEntity(tbHxpArticle);
        List<TbHxpArticle> list = tbHxpArticleManager.findPage(contextData);
        System.out.println(list.size());
        requestResolver.setAttribute("articleList",list);

//        TbHxpArticle tbHxpArticle = new TbHxpArticle();
//        tbHxpArticle.setArticleId(UUIDUtils.getUUID());
//        tbHxpArticle.setArticleTitle("此次测测测测恶策测测测测测测测测测测");
//        tbHxpArticleManager.insertArticle(tbHxpArticle);


        return "admin/article/articleList";
    }

    @RequestMapping(value = "insertArticle.html")
    public String insertArticle(){
        return "admin/article/insertArticle";
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
