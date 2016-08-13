package com.pro.test.web.admin.service;

import com.pro.test.core.common.global.BaseVariables;
import com.pro.test.core.common.mybatis.service.SimpleManager;
import com.pro.test.core.enumdata.ArticleRange;
import com.pro.test.core.util.EhcacheUtils;
import com.pro.test.core.vo.ArticleRangeVo;
import com.pro.test.web.dao.TbHxpArticleDao;
import com.pro.test.web.entity.TbHxpArticle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by hxpeng on 2016/7/1.
 */
@Service
public class TbHxpArticleManager extends SimpleManager<TbHxpArticle, TbHxpArticleDao> {


    public TbHxpArticle findOneById(String id){
        return dao.selectByPrimaryKey(id);
    }


    public int insertArticle(TbHxpArticle tbHxpArticle){
        return dao.insert(tbHxpArticle);
    }


    public List<ArticleRangeVo> getArticleRangsCountInfo() throws Exception {
        List<ArticleRangeVo> result = (List<ArticleRangeVo>) EhcacheUtils.getValue("articleRangeCountCache","articleRanges");
        if(result == null){
            result = new ArrayList<>();
            int countSize = 0;
            List<Map<String,Object>> returnMap = this.dao.findArticleRangeCount();
            for(Map<String,Object> map : returnMap){
                ArticleRange articleRange = ArticleRange.getArticleRange(map.get(BaseVariables.ARTICLE_RANGE).toString());
                ArticleRangeVo articleRangeVo = new ArticleRangeVo();
                articleRangeVo.setArticleRange(articleRange.getKey());
                articleRangeVo.setArticleRangeName(articleRange.getValue());
                articleRangeVo.setArticleRangeCount(Integer.parseInt(map.get(BaseVariables.ARTICLE_RANGE_COUNT).toString()));
                countSize += Integer.valueOf(map.get(BaseVariables.ARTICLE_RANGE_COUNT).toString());
                result.add(articleRangeVo);
            }
            ArticleRangeVo articleRangeVo = new ArticleRangeVo();
            articleRangeVo.setArticleRange("all");
            articleRangeVo.setArticleRangeName("全部");
            articleRangeVo.setArticleRangeCount(countSize);
            result.add(articleRangeVo);
            Collections.sort(result);//排序，从大到小
            EhcacheUtils.setValue("articleRangeCountCache","articleRanges",result);
        }
        return result;
    }

}
