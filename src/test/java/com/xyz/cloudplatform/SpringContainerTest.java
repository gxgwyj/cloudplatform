package com.xyz.cloudplatform;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 线程安全的单例
 * Created by Administrator on 2017/2/13.
 */
public class SpringContainerTest {
    private SpringContainerTest(){}

    private static class SpringContainerHandler{
        private static ApplicationContext ctc = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
    }
    public static ApplicationContext getCtx() {
        return SpringContainerHandler.ctc;
    }
}
