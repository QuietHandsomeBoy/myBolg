package com.pro.test.web.outside.controller;


import com.pro.test.core.common.springmvc.entity.RequestResolver;
import com.pro.test.web.admin.entity.TbHxpArticle;
import com.pro.test.web.admin.service.TbHxpArticleManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


/**
 * Created by hxpeng on 2016/6/15.
 */
@Controller
@RequestMapping(value = "/")
public class MainController {


    @Resource
    private TbHxpArticleManager tbHxpArticleManager;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, RequestResolver requestResolver) {
        requestResolver.getAttribute("");
        System.out.println("谢特！");
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        return "work/login";
    }

    @RequestMapping(value = "/accountLogin", method = RequestMethod.POST)
    @ResponseBody
    public void accountLogin(RequestResolver requestResolver){
        String  userName  =  requestResolver.getParameter("userName");
        String  userPwd  =  requestResolver.getParameter("userPwd");

        System.out.println(userName + "++" + userPwd);
        System.out.println("进来了！！！");
    }

    @RequestMapping(value = "article.html")
    public String article(RequestResolver requestResolver){
        TbHxpArticle entity = tbHxpArticleManager.findOneById("1111111");
        System.out.print(entity.getArticleIntroduced());
        return "article";
    }



    @RequestMapping(value = "admin.html")
    public String admin(RequestResolver requestResolver){

        return "work/article/articleList";
    }


}