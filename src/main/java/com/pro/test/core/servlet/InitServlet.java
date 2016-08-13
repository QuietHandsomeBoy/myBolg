package com.pro.test.core.servlet;

import com.pro.test.core.enumdata.ArticleRange;
import com.pro.test.core.util.EhcacheUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

/**
 * Created by hxpeng on 2016/6/16.
 */
public class InitServlet extends HttpServlet {

    Logger logger = LoggerFactory.getLogger(InitServlet.class);

    public void init(ServletConfig config){

        ServletContext servletContext = config.getServletContext();
//        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);

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

        logger.info("================================开始缓存常用枚举等资源！");
        try {
            EhcacheUtils.setValue("articleRangeEnumCache","articleRangeEnum", ArticleRange.getArticleRangeEnum());
            logger.info("================================常用枚举等资源缓存完成！");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
