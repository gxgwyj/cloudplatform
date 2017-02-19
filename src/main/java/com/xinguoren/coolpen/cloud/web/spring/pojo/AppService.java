package com.xinguoren.coolpen.cloud.web.spring.pojo;


/**
 * Created by Administrator on 2017/2/13.
 */
public class AppService  extends BaseService{
    public AppService(){
        System.out.println("init appService");
    }
    public void getName(){
        System.out.println("appService");
    }
}
