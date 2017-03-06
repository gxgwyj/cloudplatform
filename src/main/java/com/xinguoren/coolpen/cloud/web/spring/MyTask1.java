package com.xinguoren.coolpen.cloud.web.spring;

/**
 * Created by Administrator on 2017/2/23.
 */
public class MyTask1 extends Thread {
    private int duration;
    public MyTask1(String name,int sleepTime){
        super(name);
        duration  = sleepTime;
        start();
    }
    public void run(){
        try{
            sleep(duration);
        }catch (InterruptedException e){
            System.out.println(getName() + " was interrupted. " + "isInterrupted(): " + isInterrupted());
            return;
        }
        System.out.println(getName() + " has awakened");
    }
}
