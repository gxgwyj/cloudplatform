package com.xinguoren.coolpen.cloud.web.spring;

import com.xinguoren.coolpen.cloud.web.spring.pojo.AppService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/2/13.
 */
public class SpringContainer {
    public static void main(String[] args) {
        ApplicationContext context =new ClassPathXmlApplicationContext("spring/appConfig/service.xml");
        AppService appService1 = context.getBean(AppService.class);
        AppService appService2 = context.getBean(AppService.class);

    }
}
