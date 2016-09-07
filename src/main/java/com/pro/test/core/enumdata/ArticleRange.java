package com.pro.test.core.enumdata;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hxpeng on 2016/7/20.
 */
public enum ArticleRange {

    note("note", "笔记"),
    diary("diary", "日记"),
    tabloid("tabloid", "文摘"),
    other("other", "其他");

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

    ArticleRange(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static ArticleRange getArticleRange(String key) {
        switch (key) {
            case "note":
                return note;
            case "diary":
                return diary;
            case "tabloid":
                return tabloid;
            case "other":
                return other;
        }
        return null;
    }

    public static Map<String, Object> getArticleRangeEnum() {
        Map<String, Object> map = new HashMap<>();
        for (ArticleRange articleRange : ArticleRange.values()) {
            map.put(articleRange.getKey(), articleRange.getValue());
        }
        return map;
    }
}
