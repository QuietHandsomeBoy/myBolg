package com.pro.test.core.controller;

import com.pro.test.core.validator.ArticleValidator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * Created by hxpeng on 2016/7/25.
 */
public class BaseController {


    @InitBinder("tbHxpArticle")
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new ArticleValidator());
    }

}
