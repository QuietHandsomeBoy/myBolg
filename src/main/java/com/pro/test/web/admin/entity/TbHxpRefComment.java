package com.pro.test.web.admin.entity;

import java.util.Date;

public class TbHxpRefComment {
    private String id;

    private String articleId;

    private String commentId;

    private String refCommentId;

    private String refCommentContext;

    private String userId;

    private String userName;

    private String userHeadPortrait;

    private String toUserName;

    private String toUserId;

    private String refCommentIp;

    private Date createDate;

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

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId == null ? null : commentId.trim();
    }

    public String getRefCommentId() {
        return refCommentId;
    }

    public void setRefCommentId(String refCommentId) {
        this.refCommentId = refCommentId == null ? null : refCommentId.trim();
    }

    public String getRefCommentContext() {
        return refCommentContext;
    }

    public void setRefCommentContext(String refCommentContext) {
        this.refCommentContext = refCommentContext == null ? null : refCommentContext.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserHeadPortrait() {
        return userHeadPortrait;
    }

    public void setUserHeadPortrait(String userHeadPortrait) {
        this.userHeadPortrait = userHeadPortrait == null ? null : userHeadPortrait.trim();
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName == null ? null : toUserName.trim();
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId == null ? null : toUserId.trim();
    }

    public String getRefCommentIp() {
        return refCommentIp;
    }

    public void setRefCommentIp(String refCommentIp) {
        this.refCommentIp = refCommentIp == null ? null : refCommentIp.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}