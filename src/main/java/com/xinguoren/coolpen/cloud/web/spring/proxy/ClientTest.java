package com.xinguoren.coolpen.cloud.web.spring.proxy;

/**
 * Created by Lenovo on 2017/2/19.
 */
public class ClientTest {
    public static void main(String[] args) {
        Subject subject = new RealSubject();
        MyProxy myProxy = new MyProxy(subject);
        myProxy.operate();
    }
}
