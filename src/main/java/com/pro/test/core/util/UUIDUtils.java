package com.pro.test.core.util;

import java.util.UUID;

/**
 * Created by hxpeng on 2016/7/19.
 */
public class UUIDUtils {

    public static synchronized String getUUID(){
        UUID uuid=UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr=str.replace("-", "");
        return uuidStr;
    }
}
