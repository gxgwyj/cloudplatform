package com.xinguoren.coolpen.cloud.web.spring.proxy;

/**
 *
 * 代理类
 * Created by Lenovo on 2017/2/19.
 */
public class MyProxy implements Subject {
    private Subject subject;

    public MyProxy(Subject subject) {
        this.subject = subject;
    }

    public void operate() {
        System.out.println("before operate......");
        subject.operate();
        System.out.println("after  operate......");

    }
}
