package com.pro.test.core.enumdata;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hxpeng on 2016/7/20.
 */
public enum ArticleRights {

    original("original","原创"),
    reprint("reprint","转载"),
    translate("translate","翻译"),
    other("other","其他");

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

    public static ArticleRights getArticleRights(String key){
        switch (key)
        {
            case "original":
                return original;
            case "reprint":
                return reprint;
            case "translate":
                return translate;
            case "other":
                return other;
        }
        return null;
    }

    public static Map<String,Object> getArticleRightsEnum(){
        Map<String,Object> map = new HashMap<>();
        for(ArticleRights articleRange : ArticleRights.values()){
            map.put(articleRange.getKey(),articleRange.getValue());
        }
        return map;
    }
}
