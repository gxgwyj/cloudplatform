package com.xinguoren.coolpen.cloud.junit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 线程安全的单例
 * Created by Administrator on 2017/2/13.
 */
public class SpringContainer {
    private SpringContainer(){}

    private static class SpringContainerHandler{
        private static ApplicationContext ctc = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
    }
    public static ApplicationContext getCtx() {
        return SpringContainerHandler.ctc;
    }
}
