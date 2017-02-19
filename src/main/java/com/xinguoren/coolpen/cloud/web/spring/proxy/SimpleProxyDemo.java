package com.xinguoren.coolpen.cloud.web.spring.proxy;

/**
 * Created by Lenovo on 2017/2/19.
 */
public class SimpleProxyDemo {

    public static void consumer(Interface iface){
        iface.action1();
        iface.action2("abc");
    }

    public static void main(String[] args) {
        RealObject realObject = new RealObject();//实际的对象
        SimpleProxy simpleProxy = new SimpleProxy(realObject);//代理对象
        consumer(realObject);
        consumer(simpleProxy);


    }
}
