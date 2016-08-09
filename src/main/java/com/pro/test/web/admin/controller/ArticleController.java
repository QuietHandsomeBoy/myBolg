package com.pro.test.web.admin.controller;

import com.alibaba.fastjson.JSONObject;
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
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by hxpeng on 2016/7/14.
 */
@Controller("adminArticle")
@RequestMapping(value = "/admin/article")
public class ArticleController extends BaseController {

    @Autowired
    private TbHxpArticleManager tbHxpArticleManager;

    @RequestMapping(value = "articleList.html")
    public String articleList(Pagination pagination, RequestResolver requestResolver){
        ContextData contextData = new ContextData(pagination);
        List<TbHxpArticle> list = tbHxpArticleManager.findPage(contextData);
        requestResolver.setAttribute("articleList",list);
        return "admin/article/articleList";
    }

    @ResponseBody
    @RequestMapping(value = "articleList.json" ,method = RequestMethod.POST)
    public String articleList(Pagination pagination, TbHxpArticle tbHxpArticle, String createDateBegin, String createDateEnd){
        Map<String,Object> map = new HashMap<>();
        ContextData contextData = new ContextData(pagination);
        contextData.setEntity(tbHxpArticle);
        contextData.put("createDateBegin",createDateBegin);
        contextData.put("createDateEnd",createDateEnd);
        List<TbHxpArticle> list = tbHxpArticleManager.findPage(contextData);
        map.put("articleList",list);
        map.put("pagination",pagination);
        return JSONObject.toJSONString(map);
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

        if(tbHxpArticle!=null && tbHxpArticle.getId()==null){
            tbHxpArticle.setArticleStatus(ArticleStatus.Draft.getKey());
            tbHxpArticle.setArticleId(UUIDUtils.getUUID());
            tbHxpArticleManager.insertArticle(tbHxpArticle);
        }
        return "admin/article/articleList";
    }

}
