package com.pro.test.core.common.annotation;

/**
 * Created by hxpeng on 2016/8/23.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解类,用于标识序列名称
 *
 * @author BrainstorM
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Token {
}

