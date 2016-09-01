package com.pro.test.core.enumdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hxpeng on 2016/8/31.
 */
public enum ArticleTags {

    note("note", "笔记标签"),
    diary("diary", "日记标签"),
    tabloid("tabloid", "文摘标签"),
    other("other", "其他标签");

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

    ArticleTags(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static ArticleTags getArticleTags(String key) {
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

    public static Map<String, Object> getArticleTagsEnum() {
        Map<String, Object> map = new HashMap<>();
        for (ArticleTags articleRange : ArticleTags.values()) {
            map.put(articleRange.getKey(), articleRange.getValue());
        }
        return map;
    }

    public static List<ArticleTags> articleTagsList() {
        List<ArticleTags> list = new ArrayList<>();
        for (ArticleTags articleRange : ArticleTags.values()) {
            list.add(articleRange);
        }
        return list;
    }

}
