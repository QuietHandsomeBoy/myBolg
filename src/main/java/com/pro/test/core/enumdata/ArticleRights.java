package com.pro.test.core.enumdata;

/**
 * Created by hxpeng on 2016/7/20.
 */
public enum ArticleRights {

    Original("Original","原创"),
    Reprint("Reprint","转载"),
    Translate("Translate","翻译");

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

    ArticleRights(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
