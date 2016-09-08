package com.pro.test.web.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.pro.test.core.common.mybatis.ContextData;
import com.pro.test.core.common.mybatis.entity.Pagination;
import com.pro.test.core.common.springmvc.entity.RequestResolver;
import com.pro.test.core.enumdata.LogType;
import com.pro.test.web.admin.service.TbHxpLogsManager;
import com.pro.test.web.entity.TbHxpLogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hxpeng on 2016/9/8.
 */

@Controller("adminLogs")
@RequestMapping(value = "/admin/logs")
public class LogsController {

    @Autowired
    private TbHxpLogsManager tbHxpLogsManager;


    /**
     * log列表
     *
     * @param requestResolver
     * @param tbHxpLogs
     * @param pagination
     * @return
     */
    @RequestMapping(value = "logsList.html", method = RequestMethod.GET)
    public String tagsList(RequestResolver requestResolver, TbHxpLogs tbHxpLogs, Pagination pagination) {
        ContextData contextData = new ContextData(pagination);
        contextData.setEntity(tbHxpLogs);
        List<TbHxpLogs> list = tbHxpLogsManager.findPage(contextData);
        Map<String, Object> logTypeEnum = LogType.getLogTypeEnum();
        requestResolver.setAttribute("logTypeEnum", logTypeEnum);
        requestResolver.setAttribute("logsList", list);
        return "admin/system/logs/list";
    }

    /**
     * ajax log列表分页
     *
     * @param pagination
     * @param tbHxpLogs
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "logsList.json", method = RequestMethod.POST)
    public String tagsList(Pagination pagination, TbHxpLogs tbHxpLogs, String createDateBegin, String createDateEnd) {
        Map<String, Object> map = new HashMap<>();
        ContextData contextData = new ContextData(pagination);
        contextData.setEntity(tbHxpLogs);
        contextData.put("createDateBegin", createDateBegin);
        contextData.put("createDateEnd", createDateEnd);
        List<TbHxpLogs> list = tbHxpLogsManager.findPage(contextData);
        map.put("tagsList", list);
        map.put("pagination", pagination);
        return JSONObject.toJSONString(map);
    }

}
