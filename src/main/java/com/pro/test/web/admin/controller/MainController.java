package com.pro.test.web.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hxpeng on 2016/7/14.
 */
@Controller("adminIndex")
@RequestMapping(value = "/admin/")
public class MainController {


    @RequestMapping(value = "/")
    public String index(){
        return "admin/index";
    }


}
