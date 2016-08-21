package com.pro.test.core.helper;

import com.pro.test.core.common.global.BaseVariables;
import com.pro.test.core.common.springmvc.context.SpringContextHolder;
import com.pro.test.core.enumdata.ArticleRange;
import com.pro.test.core.util.EhcacheUtils;
import com.pro.test.core.vo.ArticleRangeVo;
import com.pro.test.web.dao.TbHxpArticleDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by hxpeng on 2016/8/19.
 */
public class StatisticsHelper {

    private static Logger logger = LoggerFactory.getLogger(StatisticsHelper.class);



    public static List<ArticleRangeVo> getArticleRangeCountCache(){
        try {
            List<ArticleRangeVo> result = (List<ArticleRangeVo>) EhcacheUtils.getValue("articleRangeCountCache","articleRanges");
            if(result == null){
                result = new ArrayList<>();
                TbHxpArticleDao tbHxpArticleDao = (TbHxpArticleDao) SpringContextHolder.getBean("tbHxpArticleDao");
                int countSize = 0;
                List<Map<String,Object>> returnMap = tbHxpArticleDao.findArticleRangeCount();
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
            }
            return result;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("================================================");
            logger.error("文章类型统计缓存加入失败！！！");
            logger.error("================================================");
            return null;
        }

    }






}
