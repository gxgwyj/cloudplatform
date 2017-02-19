package com.xinguoren.coolpen.cloud.web.spring.proxy;

/**
 * Created by Lenovo on 2017/2/19.
 */
public class SimpleProxy implements Interface {
    private Interface anInterface;

    public SimpleProxy(Interface anInterface) {
        this.anInterface = anInterface;
    }

    public void action1() {
        System.out.println("SimpleProxy action1");
        anInterface.action1();
    }

    public void action2(String args) {
        System.out.println("SimpleProxy action2:" +args);
        anInterface.action2(args);
    }
}
