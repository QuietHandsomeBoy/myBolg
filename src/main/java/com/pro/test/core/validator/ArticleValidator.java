package com.pro.test.core.validator;

import com.pro.test.web.entity.TbHxpArticle;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * 校验文章参数
 * Created by hxpeng on 2016/7/20.
 */
public class ArticleValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(TbHxpArticle.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "articleTitle", null,"文章标题不能为空！");
        ValidationUtils.rejectIfEmpty(errors, "articleRange", null,"请选择文章范围！");
        ValidationUtils.rejectIfEmpty(errors, "articleTags", null,"请为文章选择标签！");
        ValidationUtils.rejectIfEmpty(errors, "articleIntroduced", null,"请输入文章的介绍信息！");
    }
}
