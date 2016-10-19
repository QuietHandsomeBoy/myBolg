package com.pro.test.core.vo;

import com.pro.test.web.entity.TbHxpArticle;
import com.pro.test.web.entity.TbHxpTags;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by hxpeng on 2016/10/17.
 */
public class TbHxpArticleVo implements Serializable {

    private static final long serialVersionUID = -7408370488819055369L;

    private String id;

    private String articleId;

    private String articleTitle;

    private String articleIntroduced;

    private String articleRange;

    private String articleAuthorId;

    private String articleAuthorName;

    private String articleTags;

    private Integer isPublic;

    private String aboutArticleId;

    private Integer onTop;

    private String keyWords;

    private String articleRights;

    private String articleStatus;

    private Date createDate;

    private String createBy;

    private Date updateDate;

    private String updateBy;

    private String remark;

    private Integer isDeleted;

    /*文章标签字符串*/
    private String articleTagsStr;

    /*文章标签集合*/
    private List<TbHxpTags> articleTagList;

    /*文章所属笔记类型：笔记，日记，文章等等  名称*/
    private String articleRangeName;

    /*文章创作类型：原创，转载，翻译等等   名称*/
    private String articleRightsName;

    /*文章状态名称*/
    private String articleStatusName;

    /*相关文章*/
    private List<TbHxpArticle> aboutArticleList;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleIntroduced() {
        return articleIntroduced;
    }

    public void setArticleIntroduced(String articleIntroduced) {
        this.articleIntroduced = articleIntroduced;
    }

    public String getArticleRange() {
        return articleRange;
    }

    public void setArticleRange(String articleRange) {
        this.articleRange = articleRange;
    }

    public String getArticleAuthorId() {
        return articleAuthorId;
    }

    public void setArticleAuthorId(String articleAuthorId) {
        this.articleAuthorId = articleAuthorId;
    }

    public String getArticleAuthorName() {
        return articleAuthorName;
    }

    public void setArticleAuthorName(String articleAuthorName) {
        this.articleAuthorName = articleAuthorName;
    }

    public String getArticleTags() {
        return articleTags;
    }

    public void setArticleTags(String articleTags) {
        this.articleTags = articleTags;
    }

    public Integer getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Integer isPublic) {
        this.isPublic = isPublic;
    }

    public String getAboutArticleId() {
        return aboutArticleId;
    }

    public void setAboutArticleId(String aboutArticleId) {
        this.aboutArticleId = aboutArticleId;
    }

    public Integer getOnTop() {
        return onTop;
    }

    public void setOnTop(Integer onTop) {
        this.onTop = onTop;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getArticleRights() {
        return articleRights;
    }

    public void setArticleRights(String articleRights) {
        this.articleRights = articleRights;
    }

    public String getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(String articleStatus) {
        this.articleStatus = articleStatus;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getArticleTagsStr() {
        return articleTagsStr;
    }

    public void setArticleTagsStr(String articleTagsStr) {
        this.articleTagsStr = articleTagsStr;
    }

    public List<TbHxpTags> getArticleTagList() {
        return articleTagList;
    }

    public void setArticleTagList(List<TbHxpTags> articleTagList) {
        this.articleTagList = articleTagList;
    }

    public String getArticleRangeName() {
        return articleRangeName;
    }

    public void setArticleRangeName(String articleRangeName) {
        this.articleRangeName = articleRangeName;
    }

    public String getArticleRightsName() {
        return articleRightsName;
    }

    public void setArticleRightsName(String articleRightsName) {
        this.articleRightsName = articleRightsName;
    }

    public String getArticleStatusName() {
        return articleStatusName;
    }

    public void setArticleStatusName(String articleStatusName) {
        this.articleStatusName = articleStatusName;
    }

    public List<TbHxpArticle> getAboutArticleList() {
        return aboutArticleList;
    }

    public void setAboutArticleList(List<TbHxpArticle> aboutArticleList) {
        this.aboutArticleList = aboutArticleList;
    }
}
