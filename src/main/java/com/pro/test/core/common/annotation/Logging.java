package com.pro.test.core.common.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by hxpeng on 2016/9/9.
 */

@Target({java.lang.annotation.ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Logging
{
    LogType type();

    Class<?>[] obj() default {};

    String remarke();

    public static enum LogType
    {
        ADD("add"),  EDIT("edit"),  DEL("del"), ADDORDEL("addOrDel");

        private String type;

        private LogType(String type)
        {
            this.type = type;
        }

        public String getType()
        {
            return this.type;
        }

        public void setType(String type)
        {
            this.type = type;
        }
    }
}