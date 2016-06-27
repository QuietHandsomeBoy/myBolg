package com.pro.test.web.controller;


import com.pro.test.core.common.springmvc.entity.RequestResolver;
import com.pro.test.web.service.TbHxpArticleContentService;
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
public class MainController {


    @Resource
    private TbHxpArticleContentService tbHxpArticleContentService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, RequestResolver requestResolver) {
        requestResolver.getAttribute("");
        int i = tbHxpArticleContentService.test();
        System.out.println("谢特！");
        model.addAttribute("test",i);
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        return "login";
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
        return "article";
    }


}