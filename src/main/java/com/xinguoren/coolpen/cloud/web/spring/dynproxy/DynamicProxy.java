package com.xinguoren.coolpen.cloud.web.spring.dynproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Java对象动态代理
 * Created by Lenovo on 2017/2/19.
 */
public class DynamicProxy implements InvocationHandler{
    private Subject subject;

    public DynamicProxy(Subject subject) {
        this.subject = subject;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //在代理真实对象前我们可以添加一些自己的操作
        System.out.println("before rent house");
        System.out.println("Method:" + method);
        //当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
        method.invoke(subject, args);
        //在代理真实对象后我们也可以添加一些自己的操作
        System.out.println("after rent house");
        return null;
    }

}
