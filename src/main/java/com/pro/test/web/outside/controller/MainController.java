package com.pro.test.web.outside.controller;


import com.pro.test.core.common.mybatis.ContextData;
import com.pro.test.core.common.mybatis.entity.Pagination;
import com.pro.test.core.common.springmvc.entity.RequestResolver;
import com.pro.test.core.vo.TbHxpArticleVo;
import com.pro.test.web.outside.service.TbHxpArticleManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * Created by hxpeng on 2016/6/15.
 */
@Controller
@RequestMapping(value = "/")
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);


    @Autowired
    private TbHxpArticleManager tbHxpArticleManager;

    /**
     * 首页
     *
     * @param requestResolver
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(RequestResolver requestResolver, Pagination pagination) {
        ContextData contextData = new ContextData(pagination);
        List<TbHxpArticleVo> list = tbHxpArticleManager.findArticleVoPage(contextData);
//        try {
//            Map<String, Object> articleRightsEnum = (Map<String, Object>) EhcacheUtils.getValue("articleEnumCache", "articleRightsEnum");
//            if (articleRightsEnum == null) {
//                articleRightsEnum = ArticleRights.getArticleRightsEnum();
//                EhcacheUtils.setValue("articleEnumCache", "articleRightsEnum", articleRightsEnum);
//            }
//            requestResolver.setAttribute("articleRightsEnumMap", articleRightsEnum);
//        } catch (Exception e) {
//            logger.error("获取articleRights缓存异常：" + e);
//        }

        requestResolver.setAttribute("articleList", list);
        return "outside/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        return "admin/login";
    }

    @RequestMapping(value = "/accountLogin", method = RequestMethod.POST)
    @ResponseBody
    public void accountLogin(RequestResolver requestResolver) {
        String userName = requestResolver.getParameter("userName");
        String userPwd = requestResolver.getParameter("userPwd");

        System.out.println(userName + "++" + userPwd);
        System.out.println("进来了！！！");
    }

}