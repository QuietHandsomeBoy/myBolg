package com.pro.test.web.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hxpeng on 2016/8/30.
 */
@Controller
@RequestMapping(value = "tags")
public class TagsController {

    /**
     * 获取常用tag
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getAllTags",method = RequestMethod.POST)
    public Map<String,Object> getAllTags(){
        Map<String,Object> map = new HashMap<>();
        return map;
    }


}
