package com.pro.test.core.enumdata;

/**
 * Created by hxpeng on 2016/7/20.
 */
public enum ArticleStatus {

    Normal("Normal", "正常"),
    Draft("Draft", "草稿"),
    Deleted("Deleted", "已删除"),
    Secret("Secret", "私人");

    private String key;
    private String value;

    ArticleStatus(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
