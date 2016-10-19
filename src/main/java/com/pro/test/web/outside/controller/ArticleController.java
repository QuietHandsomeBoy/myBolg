package com.pro.test.web.outside.controller;

import com.pro.test.core.common.mybatis.ContextData;
import com.pro.test.core.common.mybatis.entity.Pagination;
import com.pro.test.core.common.springmvc.entity.RequestResolver;
import com.pro.test.core.enumdata.ArticleStatus;
import com.pro.test.core.vo.TbHxpArticleVo;
import com.pro.test.web.entity.TbHxpArticleContent;
import com.pro.test.web.outside.service.TbHxpArticleContentManager;
import com.pro.test.web.outside.service.TbHxpArticleManager;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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


    @RequestMapping(value = "loadArticleDataHtml.html")
    public String loadArticleDataHtml(Integer currentPage,RequestResolver requestResolver){
        Pagination pagination = new Pagination();
        pagination.setCurrentPage(currentPage);
        ContextData contextData = new ContextData(pagination);
        List<TbHxpArticleVo> list = tbHxpArticleManager.findArticleVoPage(contextData);
        requestResolver.setAttribute("articleList", list);
        return "outside/article/loadArticleHtml";
    }



    @RequestMapping(value = "articleDetail/{articleId}.html")
    public String addArticle(@PathVariable String articleId, RequestResolver requestResolver) {

        if (StringUtils.isNotBlank(articleId)) {
            TbHxpArticleVo tbHxpArticleVo = tbHxpArticleManager.findOneByArticleId(articleId);
            if (tbHxpArticleVo != null && tbHxpArticleVo.getArticleStatus().equals(ArticleStatus.normal.getKey())) {
                requestResolver.setAttribute("tbHxpArticle", tbHxpArticleVo);
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
