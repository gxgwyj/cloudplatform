package com.xinguoren.coolpen.cloud.web.spring.proxy;

/**
 * Created by Lenovo on 2017/2/19.
 */
public class RealObject implements Interface {
    public void action1() {
        System.out.println("action1");
    }

    public void action2(String args) {
        System.out.println("action2：" +args);
    }
}
