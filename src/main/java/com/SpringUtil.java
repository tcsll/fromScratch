package com;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


/**
 * @author ：shill
 * @date ：Created in 2020/6/10 16:30
 * @description : 实现ApplicationContextAware,尝试在springBoot启动的时候获取bean,实现autowire/resource相同操作
 */

@Component
public class SpringUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringUtil.applicationContext == null) {
            SpringUtil.applicationContext = applicationContext;
        }

        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.println("========ApplicationContext配置成功,在普通类可以通过调用SpringUtils.getAppContext()获取applicationContext对象");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
    }

    /** @description : 获取applicationContext */
    private static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /** @description : 通过name获取 Bean */
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    /** @description : 通过class获取Bean */
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    /** @description : 通过name,以及Clazz返回指定的Bean */
    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }

}

