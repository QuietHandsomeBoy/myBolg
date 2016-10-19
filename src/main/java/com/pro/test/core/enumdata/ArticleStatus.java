package com.pro.test.core.enumdata;

/**
 * Created by hxpeng on 2016/7/20.
 */
public enum ArticleStatus {

    normal("normal", "正常"),
    draft("draft", "草稿"),
    deleted("deleted", "已删除"),
    secret("secret", "私人");

    private String key;
    private String value;

    ArticleStatus(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static ArticleStatus getArticleStatus(String key){
        switch (key)
        {
            case "normal":
                return normal;
            case "draft":
                return draft;
            case "deleted":
                return deleted;
            case "secret":
                return secret;
        }
        return null;
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
