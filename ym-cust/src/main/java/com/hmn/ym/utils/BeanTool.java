package com.hmn.ym.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author
 */
public class BeanTool extends ApplicationObjectSupport implements ApplicationContextAware {

    static ApplicationContext context;
    private static ApplicationContext applicationContext = null;

    public static void setApplicationContext(WebApplicationContext applicationContext) {
        BeanTool.applicationContext = applicationContext;
    }

    public static ApplicationContext getAppContext() {
        return applicationContext;
    }

    public static Object getBean(String name) {
        return getAppContext().getBean(name);
    }

    public BeanTool getInstance() {
        return new BeanTool();
    }

    @Override
    protected void initApplicationContext(ApplicationContext context)
            throws BeansException {
        super.initApplicationContext(context);
        if (BeanTool.applicationContext == null) {
            BeanTool.applicationContext = context;
            System.out.println("========ApplicationContext配置成功,在普通类可以通过调用ApplicationContextTool.getAppContext()获取applicationContext对象,applicationContext=" + applicationContext + "========");
        }
    }


}