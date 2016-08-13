package com.pro.test.core.util;

import java.lang.reflect.Method;

/**
 * Created by hxpeng on 2016/8/13.
 */
public class EntityUtils {


    public static String getMethodName(String variableName) {
        return "get" + Character.toUpperCase(variableName.charAt(0)) + variableName.substring(1);
    }

    public static Object getVariableValue(Object obj, String variableName) throws Exception {
        Class<?> entityClass = obj.getClass();
        String methodName = getMethodName(variableName);
        Method method = entityClass.getMethod(methodName, new Class[0]);
        return method.invoke(obj, new Object[0]);
    }

}
