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

    public static Object getEnumValue(Object obj, String variableName) throws Exception {
        Class<?> entityClass = obj.getClass();
        String key;
        Method method;
        for (Object o : entityClass.getEnumConstants()) {
            method = o.getClass().getMethod(getMethodName("key"), new Class[0]);
            key = method.invoke(obj, new Object[0]).toString();
            if (key.equals(variableName)) {
                method = o.getClass().getMethod(getMethodName("value"), new Class[0]);
                return method.invoke(obj, new Object[0]).toString();
            }
        }
        return null;
    }
}
