package com.pro.test.core.vo;

import java.io.Serializable;

/**
 * Created by hxpeng on 2016/8/12.
 */
public class ArticleRangeVo implements Serializable,Comparable {


    private static final long serialVersionUID = 7573937216403789528L;

    private String articleRange;

    private String articleRangeName;

    private int articleRangeCount;


    public int getArticleRangeCount() {
        return articleRangeCount;
    }

    public void setArticleRangeCount(int articleRangeCount) {
        this.articleRangeCount = articleRangeCount;
    }

    public String getArticleRangeName() {
        return articleRangeName;
    }

    public void setArticleRangeName(String articleRangeName) {
        this.articleRangeName = articleRangeName;
    }

    public String getArticleRange() {
        return articleRange;
    }

    public void setArticleRange(String articleRange) {
        this.articleRange = articleRange;
    }


    /**
     * 重写compareTo，重新排序，降序
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        ArticleRangeVo articleRangeVo = (ArticleRangeVo)o;
        int countSize1 = articleRangeVo.getArticleRangeCount();
        int countSize2 = this.getArticleRangeCount();
        return countSize2>countSize1 ? -1 : 1;
    }
}
