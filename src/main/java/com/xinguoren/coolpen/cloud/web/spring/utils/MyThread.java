package com.xinguoren.coolpen.cloud.web.spring.utils;

/**
 * Created by Administrator on 2017/2/24.
 */
public class MyThread extends Thread {
    private int count = 5;
    public void run(){
        count--;
        System.out.println("由 " + this.currentThread().getName() + " 计算，count=" + count);
    }
}
