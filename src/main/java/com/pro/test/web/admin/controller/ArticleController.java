package com.pro.test.web.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.pro.test.core.common.mybatis.ContextData;
import com.pro.test.core.common.mybatis.entity.Pagination;
import com.pro.test.core.common.springmvc.entity.RequestResolver;
import com.pro.test.core.controller.BaseController;
import com.pro.test.core.enumdata.ArticleRange;
import com.pro.test.core.enumdata.ArticleRights;
import com.pro.test.core.enumdata.ArticleTags;
import com.pro.test.core.util.EhcacheUtils;
import com.pro.test.core.util.UUIDUtils;
import com.pro.test.core.vo.ArticleRangeVo;
import com.pro.test.web.admin.service.TbHxpArticleContentManager;
import com.pro.test.web.admin.service.TbHxpArticleManager;
import com.pro.test.web.admin.service.TbHxpTagsManager;
import com.pro.test.web.entity.TbHxpArticle;
import com.pro.test.web.entity.TbHxpArticleContent;
import com.pro.test.web.entity.TbHxpTags;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import java.util.*;


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

    @Autowired
    private TbHxpTagsManager tbHxpTagsManager;

    @RequestMapping(value = "articleList.html", method = RequestMethod.GET)
    public String articleList(Pagination pagination, RequestResolver requestResolver, TbHxpArticle tbHxpArticle) throws Exception {
        ContextData contextData = new ContextData(pagination);
        contextData.setEntity(tbHxpArticle);
        List<TbHxpArticle> list = tbHxpArticleManager.findPage(contextData);
        //从缓存中拿取各种笔记的count！
        List<ArticleRangeVo> articleRangsCountInfo = tbHxpArticleManager.getArticleRangsCountInfo();
        if (StringUtils.isNotBlank(tbHxpArticle.getArticleRange())) {
            requestResolver.setAttribute("articleRange", tbHxpArticle.getArticleRange());
        }
        Map<String, Object> articleRightsEnum = (Map<String, Object>) EhcacheUtils.getValue("articleEnumCache", "articleRightsEnum");
        if (articleRightsEnum == null) {
            articleRightsEnum = ArticleRights.getArticleRightsEnum();
            EhcacheUtils.setValue("articleEnumCache", "articleRightsEnum", articleRightsEnum);
        }
        requestResolver.setAttribute("articleRightsEnumMap", articleRightsEnum);
        requestResolver.setAttribute("articleRangeCount", articleRangsCountInfo);
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
     *
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


    /**
     * 跳转到修改/新增博客页面
     *
     * @param requestResolver
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "insertArticle.html", method = RequestMethod.GET)
    public String insertArticle(RequestResolver requestResolver, String articleId) throws Exception {
        long start = System.currentTimeMillis();
        Map<String, Object> articleRangeEnum = (Map<String, Object>) EhcacheUtils.getValue("articleEnumCache", "articleRangeEnum");
        if (articleRangeEnum == null) {
            articleRangeEnum = ArticleRange.getArticleRangeEnum();
            EhcacheUtils.setValue("articleEnumCache", "articleRangeEnum", articleRangeEnum);
        }
        Map<String, Object> articleRightsEnum = (Map<String, Object>) EhcacheUtils.getValue("articleEnumCache", "articleRightsEnum");
        if (articleRightsEnum == null) {
            articleRightsEnum = ArticleRights.getArticleRightsEnum();
            EhcacheUtils.setValue("articleEnumCache", "articleRightsEnum", articleRightsEnum);
        }
        Map<String, Object> articleTagsEnum = (Map<String, Object>) EhcacheUtils.getValue("articleEnumCache", "articleTagsEnum");
        if (articleTagsEnum == null) {
            articleTagsEnum = ArticleTags.getArticleTagsEnum();
            EhcacheUtils.setValue("articleEnumCache", "articleTagsEnum", articleTagsEnum);
        }
        requestResolver.setAttribute("articleTagsEnumMap", articleTagsEnum);
        requestResolver.setAttribute("articleTagsJSON", JSONObject.toJSONString(articleTagsEnum));
        requestResolver.setAttribute("articleRangeEnumMap", articleRangeEnum);
        requestResolver.setAttribute("articleRightsEnumMap", articleRightsEnum);
        if (StringUtils.isNotBlank(articleId)) {
            TbHxpArticle tbHxpArticle = tbHxpArticleManager.findOneByArticleID(articleId);
            if (null != tbHxpArticle) {
                List<String> keyWordslist = new ArrayList<>();
                String keyWords = tbHxpArticle.getKeyWords();
                if (StringUtils.isNotBlank(keyWords)) {
                    if (keyWords.indexOf(",") != -1) {
                        String[] interceptor = keyWords.split(",");
                        for (String s : interceptor) {
                            keyWordslist.add(s);
                        }
                    } else {
                        keyWordslist.add(keyWords);
                    }
                    requestResolver.setAttribute("keyWordslist", keyWordslist);
                }
                List<TbHxpTags> tagsList = new ArrayList<>();
                String tagsStr = tbHxpArticle.getArticleTags();
                String[] tag = tagsStr.split(",");
                if (tag.length >= 1) {
                    for (String s : tag) {
                        TbHxpTags entity = tbHxpTagsManager.findOneByID(s);
                        if (entity != null) {
                            tagsList.add(entity);
                        }
                    }
                    requestResolver.setAttribute("tagsList", tagsList);
                }
                List<String> aboutUrl = new ArrayList<>();
                String aboutUrlStr = tbHxpArticle.getAboutArticleId();
                String[] ids = aboutUrlStr.split(",");
                if (ids.length >= 1) {
                    for (String s : ids) {
                        aboutUrl.add("http://localhost:8082/springDemo3/article/articleDetail/" + s + ".html");
                    }
                    requestResolver.setAttribute("aboutUrl", aboutUrl);
                }

                TbHxpArticleContent tbHxpArticleContent = tbHxpArticleContentManager.findOneByArticleId(tbHxpArticle.getArticleId());
                requestResolver.setAttribute("articleContent", HtmlUtils.htmlUnescape(tbHxpArticleContent.getArticleContent()));
                requestResolver.setAttribute("tbHxpArticle", tbHxpArticle);
            } else {
                return "common/404";
            }
        } else {
            requestResolver.setAttribute("articleId", UUIDUtils.getUUID());
        }
        long end = System.currentTimeMillis();
        System.out.println("执行时间::" + (end - start));
        return "admin/article/insertArticle";
    }

    /**
     * 异步提交文章，新增/修改
     *
     * @param tbHxpArticle
     * @param content
     * @param bindingResult
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "/saveArticle.json", method = RequestMethod.POST)
    public Map<String, Object> saveArticle(@Validated TbHxpArticle tbHxpArticle, String content, BindingResult bindingResult, String newArticleId, String tagsStr) {
        Map<String, Object> map = new HashMap<>();
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            map.put("result", "err");
            map.put("resultMsg", "请按要求输入文章相关信息!");
            return map;
        }
        try {
            List<TbHxpTags> list = JSONObject.parseArray(tagsStr, TbHxpTags.class);
            StringBuffer tagsIdStr = new StringBuffer("");
            for (TbHxpTags tbHxpTags : list) {
                if (StringUtils.isBlank(tbHxpTags.getId())) {
                    tbHxpTags.setTagType(tbHxpArticle.getArticleRange());
                    tbHxpTags.setIsDeleted(0);
                    tbHxpTagsManager.insert(tbHxpTags);
                }
                tagsIdStr.append(tbHxpTags.getId() + ",");
            }
            tbHxpArticle.setArticleTags(tagsIdStr.toString());
            map = tbHxpArticleManager.insertArticle(tbHxpArticle, newArticleId, content);
            map.put("result", "success");
        } catch (Exception e) {
            map.put("result", "err");
            map.put("resultMsg", "系统后台错误！");
        }
        return map;
    }

    /**
     * 跟根据文章ID判断文章是否存在
     *
     * @param articleId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "isArticle.json", method = RequestMethod.POST)
    public Map<String, Object> isArticle(String articleId) {
        Map<String, Object> map = new HashMap<>();
        map.put("result", "false");
        try {
            TbHxpArticle tbHxpArticle = tbHxpArticleManager.findOneByArticleID(articleId);
            if (tbHxpArticle != null) {
                map.put("result", "true");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("result", "err");
        }
        return map;
    }

}
