package com.pro.test.core.common.springmvc.context;

import com.pro.test.core.service.SystemConfigSevice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hxpeng on 2016/8/16.
 */
public class SpringContextHolder implements ApplicationContextAware {


    private static Logger log = LoggerFactory.getLogger(SpringContextHolder.class);
    private static ApplicationContext applicationContext;



    public static ApplicationContext getApplicationContext() {
        if (applicationContext == null) {
            throw new IllegalStateException("'applicationContext' property is null,ApplicationContextHolder not yet init.");
        }
        return applicationContext;
    }

    private static Map<Class,Object> beans = new HashMap<Class, Object>();
    public static <T> T getBean(Class<T> requiredType) {
        if(beans.get(requiredType)!=null){
            return (T)beans.get(requiredType);
        } else {
            Object instance = getApplicationContext().getBean(requiredType);
            beans.put(requiredType,instance);
            return (T)instance;
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (this.applicationContext != null) {
            log.error("ApplicationContextHolder already holded 'applicationContext'.");
        }
        this.applicationContext = applicationContext;
        log.debug("holded applicationContext,displayName:" + applicationContext.getDisplayName());
    }

    public static Object getBean(String beanName) {
        return getApplicationContext().getBean(beanName);
    }

    public static <T> Map<String, T> getBeansOfType(Class<T> requiredType){
        return getApplicationContext().getBeansOfType(requiredType);
    }

    public static SystemConfigSevice getSystemConfigSevice(){
        return getBean(SystemConfigSevice.class);
    }

    public static void cleanHolder() {
        applicationContext = null;
    }

}
