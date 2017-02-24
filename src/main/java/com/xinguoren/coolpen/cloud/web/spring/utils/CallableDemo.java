package com.xinguoren.coolpen.cloud.web.spring.utils;

import com.xinguoren.coolpen.cloud.web.spring.TaskWithResult;

import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Administrator on 2017/2/23.
 */
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exc = Executors.newCachedThreadPool();
        ArrayList<Future<String>> futures = new ArrayList<Future<String>>();
        for (int i = 0; i < 10 ; i++) {
            futures.add(exc.submit(new TaskWithResult(i)));
        }
        for (Future future:futures){
            try{
                System.out.println(future.get());//使用get获取的时候，将一直阻塞到任务运行完成后结果返回
            }catch (InterruptedException e){
                System.out.println(e);
                return;
            }catch (ExecutionException e){
                System.out.println(e);
                return;
            }finally {
                exc.shutdown();
            }
        }
    }
}
