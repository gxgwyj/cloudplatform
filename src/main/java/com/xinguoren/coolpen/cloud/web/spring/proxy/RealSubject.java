package com.xinguoren.coolpen.cloud.web.spring.proxy;

/**
 * Created by Lenovo on 2017/2/19.
 */
public class RealSubject implements Subject {

    public void operate() {
        System.out.println("realsubject operatestarted......");
    }
}
