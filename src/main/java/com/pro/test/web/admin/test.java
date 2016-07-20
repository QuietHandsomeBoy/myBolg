package com.pro.test.web.admin;

import com.pro.test.web.admin.entity.TbHxpArticle;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created by hxpeng on 2016/7/20.
 */
public class test {

    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        TbHxpArticle entity = new TbHxpArticle();
        entity.setArticleTitle("111111");
        Set<ConstraintViolation<TbHxpArticle>> constraintViolations = validator.validate(entity);
        for (ConstraintViolation<TbHxpArticle> constraintViolation : constraintViolations) {
            System.out.println("对象属性:"+constraintViolation.getPropertyPath());
            System.out.println("国际化key:"+constraintViolation.getMessageTemplate());
            System.out.println("错误信息:"+constraintViolation.getMessage());
        }

    }
}
