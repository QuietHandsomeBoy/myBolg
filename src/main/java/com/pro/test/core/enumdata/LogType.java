package com.pro.test.core.enumdata;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hxpeng on 2016/9/8.
 */
public enum LogType {

    operation("operation", "操作日志"),
    err("err", "异常日志"),
    other("other", "其他日志"),
    system("system", "系统日志");

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

    LogType(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static LogType getLogType(String key) {
        switch (key) {
            case "operation":
                return operation;
            case "err":
                return err;
            case "system":
                return system;
            case "other":
                return other;
        }
        return null;
    }

    public static Map<String, Object> getLogTypeEnum() {
        Map<String, Object> map = new HashMap<>();
        for (LogType logType : LogType.values()) {
            map.put(logType.getKey(), logType.getValue());
        }
        return map;
    }

}
