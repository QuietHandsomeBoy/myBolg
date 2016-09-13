package com.pro.test.core.listener;

import com.pro.test.core.common.global.BaseVariables;
import com.pro.test.core.common.springmvc.context.SpringContextHolder;
import com.pro.test.core.common.springmvc.thread.LogHandleThread;
import com.pro.test.core.enumdata.ArticleRange;
import com.pro.test.core.enumdata.ArticleRights;
import com.pro.test.core.enumdata.ArticleTags;
import com.pro.test.core.helper.StatisticsHelper;
import com.pro.test.core.util.EhcacheUtils;
import com.pro.test.web.dao.TbHxpArticleDao;
import com.pro.test.web.dao.TbHxpTagsDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by hxpeng on 2016/9/9.
 */
public class MyContextInitListener implements ServletContextListener {

    private static final Logger logger = LoggerFactory.getLogger(MyContextInitListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        logger.info("================================开始初始化静态资源路径信息！");
        String contextPath = servletContext.getContextPath();
        String resourcesPath = contextPath + "/resources";
        servletContext.setAttribute("_Weburl", contextPath);
        servletContext.setAttribute("_resourcesUrl", resourcesPath);
        servletContext.setAttribute("_cssUrl", resourcesPath + "/css");
        servletContext.setAttribute("_jsUrl", resourcesPath + "/js");
        servletContext.setAttribute("_imagesUrl", resourcesPath + "/images");
        servletContext.setAttribute("_adminJsUrl", resourcesPath + "/js/admin");
        servletContext.setAttribute("_outsideJsUrl", resourcesPath + "/js/outside");
        servletContext.setAttribute("_commonJsUrl", resourcesPath + "/js/common");
        logger.info("================================静态资源路径信息初始化完成！");

        logger.info("================================开始加载相关统计信息！");
        try {
            TbHxpArticleDao tbHxpArticleDao = (TbHxpArticleDao) SpringContextHolder.getBean("tbHxpArticleDao");
            servletContext.setAttribute("article_count_num", tbHxpArticleDao.findCount("findAllCount",null));
            TbHxpTagsDao tbHxpTagsDao = (TbHxpTagsDao) SpringContextHolder.getBean("tbHxpTagsDao");
            servletContext.setAttribute("article_tag_count_num", tbHxpTagsDao.findCount("findAllCount",null));
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("================================完成加载相关统计信息！");

        try {
            EhcacheUtils.setValue("articleEnumCache", "articleRangeEnum", ArticleRange.getArticleRangeEnum());
            EhcacheUtils.setValue("articleEnumCache", "articleRightsEnum", ArticleRights.getArticleRightsEnum());
            EhcacheUtils.setValue("articleEnumCache", "articleTagssEnum", ArticleTags.getArticleTagsEnum());


            EhcacheUtils.setValue("articleRangeCountCache", "articleRanges", StatisticsHelper.getArticleRangeCountCache());
            logger.info("================================常用枚举等资源缓存完成！");
        } catch (Exception e) {
            e.printStackTrace();
        }



        //执行录入操作日志线程
        new LogHandleThread(servletContext).start();

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        BaseVariables.global_running_flag = false;
        logger.info("[系统监听]：程序关闭");
    }
}
