package com.xinguoren.coolpen.cloud.web.spring;

/**
 * Created by Administrator on 2017/2/23.
 */
public class MyTask2  extends Thread{
    private  MyTask1 myTask1;

    public MyTask2(String name,MyTask1 myTask1) {
        super(name);
        this.myTask1 = myTask1;
        start();
    }
    public void run(){
        try{
            myTask1.join();
        }catch (InterruptedException e){
            System.out.println("Interrupted");
        }
        System.out.println(getName() + " join completed");
    }
}
