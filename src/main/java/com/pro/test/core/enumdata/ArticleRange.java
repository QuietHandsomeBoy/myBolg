package com.pro.test.core.enumdata;

/**
 * Created by hxpeng on 2016/7/20.
 */
public enum  ArticleRange {

    Note("Note","笔记"),
    Diary("Diary","日记"),
    Other("Other","其他");

    private String key;
    private String value;

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

    ArticleRange(String key, String value){
        this.key = key;
        this.value = value;
    }
}
