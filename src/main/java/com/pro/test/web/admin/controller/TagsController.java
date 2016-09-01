package com.pro.test.web.admin.controller;

import com.pro.test.core.common.mybatis.ContextData;
import com.pro.test.core.common.mybatis.entity.Pagination;
import com.pro.test.core.common.springmvc.entity.RequestResolver;
import com.pro.test.core.enumdata.ArticleTags;
import com.pro.test.core.util.EhcacheUtils;
import com.pro.test.web.admin.service.TbHxpTagsManager;
import com.pro.test.web.entity.TbHxpTags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by hxpeng on 2016/8/30.
 */
@Controller("adminTags")
@RequestMapping(value = "/admin/tags")
public class TagsController {

    @Autowired
    private TbHxpTagsManager tbHxpTagsManager;

    @RequestMapping(value = "tagsList.html", method = RequestMethod.GET)
    public String tagsList(RequestResolver requestResolver, TbHxpTags tbHxpTags, Pagination pagination) {
        pagination.setPageSize(30);
        ContextData contextData = new ContextData(pagination);
        contextData.setEntity(tbHxpTags);
        List<TbHxpTags> list = tbHxpTagsManager.findPage(contextData);
        try {
            Map<String, Object> articleTagsEnum = (Map<String, Object>) EhcacheUtils.getValue("articleEnumCache", "articleTagsEnum");
            if (articleTagsEnum == null) {
                articleTagsEnum = ArticleTags.getArticleTagsEnum();
                EhcacheUtils.setValue("articleEnumCache", "articleRightsEnum", articleTagsEnum);
                requestResolver.setAttribute("articleTagsEnumMap",articleTagsEnum);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        requestResolver.setAttribute("tagsList",list);
        return "admin/system/tag/list";
    }


    /**
     * 条件查询tags
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getTagsByConditions", method = RequestMethod.POST)
    public String getAllTags(String conditions) {
        List<TbHxpTags> list = new ArrayList<>();


        return "";
    }


}
