package com.xinguoren.coolpen.cloud.web.spring;

/**
 * Created by Administrator on 2017/2/23.
 */
public class MyTask implements Runnable {
    public void run() {
        for (int i = 0; i < 100 ; i++) {
            System.out.print("mytask："+ i);
        }
    }
}
