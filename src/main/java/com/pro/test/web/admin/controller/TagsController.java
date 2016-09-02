package com.pro.test.web.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.pro.test.core.common.mybatis.ContextData;
import com.pro.test.core.common.mybatis.entity.Pagination;
import com.pro.test.core.common.springmvc.entity.RequestResolver;
import com.pro.test.core.enumdata.ArticleTags;
import com.pro.test.core.util.EhcacheUtils;
import com.pro.test.web.admin.service.TbHxpTagsManager;
import com.pro.test.web.entity.TbHxpTags;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.HashMap;
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


    /**
     * tag列表
     *
     * @param requestResolver
     * @param tbHxpTags
     * @param pagination
     * @return
     */
    @RequestMapping(value = "tagsList.html", method = RequestMethod.GET)
    public String tagsList(RequestResolver requestResolver, TbHxpTags tbHxpTags, Pagination pagination) {
        ContextData contextData = new ContextData(pagination);
        contextData.setEntity(tbHxpTags);
        List<TbHxpTags> list = tbHxpTagsManager.findPage(contextData);
        try {
            Map<String, Object> articleTagsEnum = (Map<String, Object>) EhcacheUtils.getValue("articleEnumCache", "articleTagsEnum");
            if (articleTagsEnum == null) {
                articleTagsEnum = ArticleTags.getArticleTagsEnum();
                EhcacheUtils.setValue("articleEnumCache", "articleTagsEnum", articleTagsEnum);
            }
            requestResolver.setAttribute("articleTagsEnumMap", articleTagsEnum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        requestResolver.setAttribute("tagsList", list);
        return "admin/system/tag/list";
    }


    /**
     * ajax tag列表分页
     *
     * @param pagination
     * @param tbHxpTags
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "tagsList.json", method = RequestMethod.POST)
    public String tagsList(Pagination pagination, TbHxpTags tbHxpTags) {
        Map<String, Object> map = new HashMap<>();
        ContextData contextData = new ContextData(pagination);
        contextData.setEntity(tbHxpTags);
        List<TbHxpTags> list = tbHxpTagsManager.findPage(contextData);
        map.put("tagsList", list);
        map.put("pagination", pagination);
        return JSONObject.toJSONString(map);
    }


    @ResponseBody
    @RequestMapping(value = "findTags.json", method = RequestMethod.POST)
    public String findTags(TbHxpTags tbHxpTags) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<TbHxpTags> list = tbHxpTagsManager.findAllByCondition(tbHxpTags);
            if(list.size() > 0){
                map.put("stat","success");
                map.put("tagList",list);
            }else{
                map.put("stat","null");
            }
        }catch (Exception e){
            map.put("stat","err");
        }
        return JSONObject.toJSONString(map);
    }

    /**
     * 批量或单个删除标签
     *
     * @param tagIds
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "deleteTagByIds.json", method = RequestMethod.POST)
    public String deleteTagByIds(String tagIds) {
        if (StringUtils.isEmpty(tagIds)) {
            return "null";
        }
        String[] ids = tagIds.split(";");
        int length = ids.length;
        if (length < 1) {
            return "err";
        }
        tbHxpTagsManager.deleteByIds(Arrays.asList(ids));
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "saveTgas.json", method = RequestMethod.POST)
    public String saveTags(String articleId,String tagsName){

        return "";
    }



}
