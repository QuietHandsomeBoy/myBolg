package com.pro.test.web.admin.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.pro.test.core.common.mybatis.ContextData;
import com.pro.test.core.common.mybatis.entity.Pagination;
import com.pro.test.core.common.springmvc.entity.RequestResolver;
import com.pro.test.core.controller.BaseController;
import com.pro.test.core.enumdata.ArticleRange;
import com.pro.test.core.enumdata.ArticleRights;
import com.pro.test.core.util.EhcacheUtils;
import com.pro.test.core.util.UUIDUtils;
import com.pro.test.core.vo.ArticleRangeVo;
import com.pro.test.web.admin.service.TbHxpArticleContentManager;
import com.pro.test.web.admin.service.TbHxpArticleManager;
import com.pro.test.web.entity.TbHxpArticle;
import com.pro.test.web.entity.TbHxpArticleContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
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

    @Autowired
    private TbHxpArticleContentManager tbHxpArticleContentManager;

    @RequestMapping(value = "articleList.html")
    public String articleList(Pagination pagination, RequestResolver requestResolver,TbHxpArticle tbHxpArticle) throws Exception {
        ContextData contextData = new ContextData(pagination);
        contextData.setEntity(tbHxpArticle);
        List<TbHxpArticle> list = tbHxpArticleManager.findPage(contextData);
        //从缓存中拿取各种笔记的count！
        List<ArticleRangeVo> articleRangsCountInfo = tbHxpArticleManager.getArticleRangsCountInfo();

        requestResolver.setAttribute("articleRangeCount",articleRangsCountInfo);
        requestResolver.setAttribute("articleList", list);
        return "admin/article/articleList";
    }

    @ResponseBody
    @RequestMapping(value = "articleList.json", method = RequestMethod.POST)
    public String articleList(Pagination pagination, TbHxpArticle tbHxpArticle, String createDateBegin, String createDateEnd) {
        Map<String, Object> map = new HashMap<>();
        ContextData contextData = new ContextData(pagination);
        contextData.setEntity(tbHxpArticle);
        contextData.put("createDateBegin", createDateBegin);
        contextData.put("createDateEnd", createDateEnd);
        List<TbHxpArticle> list = tbHxpArticleManager.findPage(contextData);
        map.put("articleList", list);
        map.put("pagination", pagination);
        return JSONObject.toJSONString(map);
    }

    /**
     * 批量或单个删除文章
     * @param articleIds
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "deleteArticleByIds.json", method = RequestMethod.POST)
    public String deleteArticleByIds(String articleIds) {
        if (StringUtils.isEmpty(articleIds)) {
            return "null";
        }
        String[] ids = articleIds.split(";");
        int length = ids.length;
        if (length < 1) {
            return "err";
        }
        tbHxpArticleManager.deleteByIds(Arrays.asList(ids));
        return "success";
    }


    @RequestMapping(value = "insertArticle.html")
    public String insertArticle(RequestResolver requestResolver) throws Exception {
        Map<String,Object> articleRangeEnum = (Map<String,Object>) EhcacheUtils.getValue("articleEnumCache","articleRangeEnum");
        if(articleRangeEnum == null){
            articleRangeEnum = ArticleRange.getArticleRangeEnum();
            EhcacheUtils.setValue("articleEnumCache","articleRangeEnum",articleRangeEnum);
        }
        Map<String,Object> articleRightsEnum = (Map<String,Object>) EhcacheUtils.getValue("articleEnumCache","articleRightsEnum");
        if(articleRightsEnum == null){
            articleRightsEnum = ArticleRights.getArticleRightsEnum();
            EhcacheUtils.setValue("articleEnumCache","articleRightsEnum",articleRightsEnum);
        }
        requestResolver.setAttribute("articleRangeEnumMap",articleRangeEnum);
        requestResolver.setAttribute("articleRightsEnumMap",articleRightsEnum);
        requestResolver.setAttribute("articleId", UUIDUtils.getUUID());
        return "admin/article/insertArticle";
    }

    @ResponseBody
    @RequestMapping(value = "/saveArticle.json", method = RequestMethod.POST)
    public Map<String,Object> saveArticle(@Validated TbHxpArticle tbHxpArticle, String content, BindingResult bindingResult) {
        Map<String,Object> map = new HashMap<>();
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            map.put("result","err");
            map.put("resultMsg","请按要求输入文章相关信息!");
            return map;
        }
        if (tbHxpArticle != null && tbHxpArticle.getId() == null) {
            try {
                tbHxpArticleManager.insertArticle(tbHxpArticle);
                TbHxpArticleContent tbHxpArticleContent = new TbHxpArticleContent();
                tbHxpArticleContent.setArticleId(tbHxpArticle.getArticleId());
                tbHxpArticleContent.setArticleContent(content);
                tbHxpArticleContentManager.insert(tbHxpArticleContent);
            }catch (Exception e){
                e.printStackTrace();
                map.put("result","err");
                map.put("resultMsg","系统后台错误！");
                return map;
            }
        }


        return map;
    }


}
