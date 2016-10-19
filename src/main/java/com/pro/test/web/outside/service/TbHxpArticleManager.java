package com.pro.test.web.outside.service;

import com.pro.test.core.common.mybatis.ContextData;
import com.pro.test.core.common.mybatis.service.SimpleManager;
import com.pro.test.core.enumdata.ArticleRange;
import com.pro.test.core.enumdata.ArticleRights;
import com.pro.test.core.enumdata.ArticleStatus;
import com.pro.test.core.vo.TbHxpArticleVo;
import com.pro.test.web.admin.service.TbHxpTagsManager;
import com.pro.test.web.dao.TbHxpArticleDao;
import com.pro.test.web.entity.TbHxpArticle;
import com.pro.test.web.entity.TbHxpTags;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hxpeng on 2016/7/1.
 */
@Service(value = "outsideArticleManager")
public class TbHxpArticleManager extends SimpleManager<TbHxpArticle, TbHxpArticleDao> {

    @Autowired
    private TbHxpTagsManager tbHxpTagsManager;

    public TbHxpArticleVo findOneById(String id){
        TbHxpArticle entity = dao.selectByPrimaryKey(id);
        return getVo(entity);
    }

    public TbHxpArticleVo findOneByArticleId(String articleId){
        TbHxpArticle entity = dao.findOneByArticleID(articleId);
        return getVo(entity);
    }

    public List<TbHxpArticleVo> findArticleVoPage(ContextData contextData){
        List<TbHxpArticleVo> resultList = new ArrayList<>();
        if(contextData == null){
            throw new NullPointerException("查询实体不能为空!");
        }
        List<TbHxpArticle> paramList = this.dao.findPage(contextData);
        for(TbHxpArticle entity : paramList){
            TbHxpArticleVo tbHxpArticleVo = getVo(entity);
            if(tbHxpArticleVo != null){
                resultList.add(tbHxpArticleVo);
            }
        }
        return resultList;
    }

    public TbHxpArticleVo getVo(TbHxpArticle entity){
        try {
            if(null != entity){
                TbHxpArticleVo tbHxpArticleVo = new TbHxpArticleVo();
                BeanUtils.copyProperties(entity,tbHxpArticleVo);

                StringBuffer tagsStr = new StringBuffer("");
                String[] tags = entity.getArticleTags().split(",");
                if(StringUtils.isNotBlank(entity.getArticleTags()) && tags.length > 0){
                    List<TbHxpTags> list = new ArrayList<>();
                    for(String s : tags){
                        TbHxpTags tbHxpTags = tbHxpTagsManager.findOneByID(s);
                        if(null != tbHxpTags){
                            list.add(tbHxpTags);
                            tagsStr.append(tbHxpTags.getTagName()+",");
                        }
                    }
                    tbHxpArticleVo.setArticleTagList(list);
                    tbHxpArticleVo.setArticleTagsStr(tagsStr.substring(0,tagsStr.length()-1));
                }

                tbHxpArticleVo.setArticleRangeName(ArticleRange.getArticleRange(entity.getArticleRange()).getValue());
                tbHxpArticleVo.setArticleRightsName(ArticleRights.getArticleRights(entity.getArticleRights()).getValue());
                tbHxpArticleVo.setArticleStatusName(ArticleStatus.getArticleStatus(entity.getArticleStatus()).getValue());

                if(StringUtils.isNotBlank(entity.getAboutArticleId())){
                    String[] aboutArticles = entity.getAboutArticleId().split(",");
                    List<TbHxpArticle> list = new ArrayList<>();
                    for(String s : aboutArticles){
                        TbHxpArticle tbHxpArticle = this.dao.findOneByArticleID(s);
                        if(null != tbHxpArticle){
                            list.add(tbHxpArticle);
                        }
                    }
                    tbHxpArticleVo.setAboutArticleList(list);
                }
                return tbHxpArticleVo;
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("[文章实体转换VO异常：]" + e.getMessage());
        }
        return null;
    }

}
