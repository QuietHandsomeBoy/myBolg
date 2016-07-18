package com.pro.test.core.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

/**
 * Created by hxpeng on 2016/6/16.
 */
public class InitServlet extends HttpServlet {

    public void init(ServletConfig config){

        ServletContext servletContext = config.getServletContext();
//        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);

        String contextPath = servletContext.getContextPath();
        String resourcesPath = contextPath + "/resources";
        servletContext.setAttribute("_Weburl", contextPath);
        servletContext.setAttribute("_cssUrl", resourcesPath + "/css");
        servletContext.setAttribute("_jsUrl", resourcesPath + "/js");
        servletContext.setAttribute("_imagesUrl", resourcesPath + "/images");
        servletContext.setAttribute("_adminCssUrl", resourcesPath + "/admin/css");
        servletContext.setAttribute("_adminJsUrl", resourcesPath + "/admin/js");
        servletContext.setAttribute("_adminImagesUrl", resourcesPath + "/admin/images");
        System.out.println("路径等变量初始化完成！");



    }
}
