package com.pro.test.web.admin.entity;

public class TbHxpUser {
    private String id;

    private String userId;

    private String userName;

    private Integer publishCount;

    private Integer commentsCount;

    private String likeTags;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public Integer getPublishCount() {
        return publishCount;
    }

    public void setPublishCount(Integer publishCount) {
        this.publishCount = publishCount;
    }

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

    public String getLikeTags() {
        return likeTags;
    }

    public void setLikeTags(String likeTags) {
        this.likeTags = likeTags == null ? null : likeTags.trim();
    }
}