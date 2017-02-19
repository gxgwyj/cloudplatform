package com.xinguoren.coolpen.cloud.web.spring.dynproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 代理对象
 * Created by Lenovo on 2017/2/19.
 */
public class ClientTest {
    public static void main(String[] args) {
        //我们要代理的真实对象
        Subject realSubject = new RealSubject();
        //（代理对象处理类）我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
        InvocationHandler handler = new DynamicProxy(realSubject);
        //使用Java提供的Proxy创建代理对象
        /**
         * 同时我们一定要记住，通过 Proxy.newProxyInstance 创建的代理对象是在jvm运行时动态生成的一个对象，
         * 它并不是我们的InvocationHandler类型，也不是我们定义的那组接口的类型，而是在运行是动态生成的一个对象，
         * 并且命名方式都是这样的形式，以$开头，proxy为中，最后一个数字表示对象的标号。
         *
         */
        Subject proxySubject = (Subject)Proxy.newProxyInstance(handler.getClass().getClassLoader(),realSubject.getClass().getInterfaces(),handler);
        System.out.println(proxySubject.getClass().getName());
        proxySubject.rent();
        proxySubject.hello("world");
    }
}
