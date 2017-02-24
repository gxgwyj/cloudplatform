package com.xinguoren.coolpen.cloud.web.spring.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 饭店餐馆
 * Created by Administrator on 2017/2/24.
 */
public class Restaurant {
    Meal meal;
    ExecutorService exec = Executors.newCachedThreadPool();
    WaitPerson waitPerson = new WaitPerson(this);
    Chef chef = new Chef(this);
    public Restaurant(){
        exec.execute(chef);
        exec.execute(waitPerson);
    }
    public static void main(String[] args){
        new Restaurant();
    }
}
