package com.xinguoren.coolpen.cloud.web.spring.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/2/23.
 */
public class EvenChecker implements Runnable {
    private IntGenerator intGenerator;
    private final int id;

    public EvenChecker(int id, IntGenerator intGenerator) {
        this.id = id;
        this.intGenerator = intGenerator;
    }

    public void run() {
        while (!intGenerator.isCanceled()){
            int val = intGenerator.next();
            System.out.println(val);
            if (val % 2 != 0){
                System.out.println(val + " not even!");
                intGenerator.cancel();
            }
        }
    }
    public static void test(IntGenerator gp,int count){
        ExecutorService exc = Executors.newCachedThreadPool();
        for (int i = 0; i < count ; i++) {
            exc.execute(new EvenChecker(i,gp));
        }
        exc.shutdown();
    }
    public static void test(IntGenerator gp){
        test(gp,10);
    }
}
