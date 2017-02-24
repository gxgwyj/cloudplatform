package com.xinguoren.coolpen.cloud.web.spring.utils;

import com.xinguoren.coolpen.cloud.web.spring.LiftOff;
import com.xinguoren.coolpen.cloud.web.spring.MyTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池测试
 * Created by Administrator on 2017/2/23.
 */
public class CachedThreadPool {
    public static void main(String[] args) {
//        ExecutorService exec = Executors.newCachedThreadPool();
//        ExecutorService exec = Executors.newSingleThreadExecutor();
        ExecutorService exec = Executors.newFixedThreadPool(5);
        exec.execute(new MyTask());
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
