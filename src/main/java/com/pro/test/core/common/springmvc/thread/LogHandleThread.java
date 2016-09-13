package com.pro.test.core.common.springmvc.thread;

import com.alibaba.fastjson.JSONObject;
import com.pro.test.core.common.global.BaseVariables;
import com.pro.test.core.common.global.WebConstants;
import com.pro.test.core.common.springmvc.context.SpringContextHolder;
import com.pro.test.core.util.LogUtils;
import com.pro.test.web.admin.service.TbHxpLogsManager;
import com.pro.test.web.entity.TbHxpLogs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by hxpeng on 2016/9/9.
 */
public class LogHandleThread extends Thread {

    private static final Logger logger = LoggerFactory.getLogger(LogHandleThread.class);

    private static final String logHeader = "[操作日志处理]:";

    private static final int LOG_LIST_SIZE = 1000;

    private static int err_count = 5;

    private ServletContext servletContext;

    public LogHandleThread(ServletContext servletContext) {
        this.servletContext = servletContext;
    }


    public void run() {
        logger.info(logHeader + "线程启动");

        // 打印log间隔
        long timeMillis = System.currentTimeMillis();

        ConcurrentLinkedQueue<TbHxpLogs> logsQueue = (ConcurrentLinkedQueue<TbHxpLogs>)
                servletContext.getAttribute(WebConstants.APPLICATION_ATTR_NAME_LOGGING_OPER);

        int count = 0;
        List<TbHxpLogs> logsList = new ArrayList<>();

        if (logsQueue == null) {
            logsQueue = new ConcurrentLinkedQueue<>();
            servletContext.setAttribute(WebConstants.APPLICATION_ATTR_NAME_LOGGING_OPER, logsQueue);
        }

        while (BaseVariables.global_running_flag) {
            System.out.println("++++++++++++++++++++++循环一次++++++++++++++++++++++");
            if (!logsQueue.isEmpty() && count < LOG_LIST_SIZE) {
                TbHxpLogs tbHxpLogs = logsQueue.poll();
                if (tbHxpLogs != null) {
                    if (tbHxpLogs.getOperationContent().length() > 500) {
                        tbHxpLogs.setOperationContent(tbHxpLogs.getOperationContent().substring(0, 500));
                    }
                    logsList.add(tbHxpLogs);
                    count++;
                }
                continue;
            }
            if (count > 0) {
                try {
                    TbHxpLogsManager tbHxpLogsManager = (TbHxpLogsManager) SpringContextHolder.getBean("tbHxpLogsManager");
                    for (TbHxpLogs tbHxpLogs : logsList) {
                        tbHxpLogsManager.insert(tbHxpLogs);
                    }
                } catch (Exception e) {
                    LogUtils.writeLog(new StringBuffer(JSONObject.toJSONString(logsList)));
                    logger.error("Exception:" + e);
                }

                logsList.clear();
                count = 0;
            } else {
                long currentTimeMillis = System.currentTimeMillis();

                if (currentTimeMillis - timeMillis >= 60 * 1000) {
                    timeMillis = currentTimeMillis;
                    logger.info(logHeader + "没有数据需要处理");
                }

                for (int i = 0; BaseVariables.global_running_flag && i < 5; i++) {
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        logger.info("Exception: ", e);
                    }
                }
            }
        }
    }


}
