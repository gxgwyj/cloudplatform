package com.xinguoren.coolpen.cloud.web.spring.dynproxy;

/**
 * Created by Lenovo on 2017/2/19.
 */
public class RealSubject implements Subject {
    public void rent(){
        System.out.println("I want to rent my house");
    }
    public void hello(String str){
        System.out.println("hello: " + str);
    }

}
