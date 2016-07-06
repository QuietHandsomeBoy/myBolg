package com.pro.test.web.entity;

import java.util.Date;

public class TbHxpArticle {
    private String id;

    private String articleId;

    private String articleTitle;

    private String articleIntroduced;

    private String articleAuthorId;

    private String articleAuthorName;

    private String articleTags;

    private Date lastCommentDate;

    private Integer commentCount;

    private Integer likesCount;

    private Integer readCount;

    private Integer isOpen;

    private Integer onTop;

    private Integer articleFloor;

    private Integer authorSupport;

    private String keyWords;

    private Integer isContentFinish;

    private Date createDate;

    private String createBy;

    private Date updateDate;

    private String updateBy;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId == null ? null : articleId.trim();
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    public String getArticleIntroduced() {
        return articleIntroduced;
    }

    public void setArticleIntroduced(String articleIntroduced) {
        this.articleIntroduced = articleIntroduced == null ? null : articleIntroduced.trim();
    }

    public String getArticleAuthorId() {
        return articleAuthorId;
    }

    public void setArticleAuthorId(String articleAuthorId) {
        this.articleAuthorId = articleAuthorId == null ? null : articleAuthorId.trim();
    }

    public String getArticleAuthorName() {
        return articleAuthorName;
    }

    public void setArticleAuthorName(String articleAuthorName) {
        this.articleAuthorName = articleAuthorName == null ? null : articleAuthorName.trim();
    }

    public String getArticleTags() {
        return articleTags;
    }

    public void setArticleTags(String articleTags) {
        this.articleTags = articleTags == null ? null : articleTags.trim();
    }

    public Date getLastCommentDate() {
        return lastCommentDate;
    }

    public void setLastCommentDate(Date lastCommentDate) {
        this.lastCommentDate = lastCommentDate;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public Integer getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Integer isOpen) {
        this.isOpen = isOpen;
    }

    public Integer getOnTop() {
        return onTop;
    }

    public void setOnTop(Integer onTop) {
        this.onTop = onTop;
    }

    public Integer getArticleFloor() {
        return articleFloor;
    }

    public void setArticleFloor(Integer articleFloor) {
        this.articleFloor = articleFloor;
    }

    public Integer getAuthorSupport() {
        return authorSupport;
    }

    public void setAuthorSupport(Integer authorSupport) {
        this.authorSupport = authorSupport;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords == null ? null : keyWords.trim();
    }

    public Integer getIsContentFinish() {
        return isContentFinish;
    }

    public void setIsContentFinish(Integer isContentFinish) {
        this.isContentFinish = isContentFinish;
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
        this.createBy = createBy == null ? null : createBy.trim();
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
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}