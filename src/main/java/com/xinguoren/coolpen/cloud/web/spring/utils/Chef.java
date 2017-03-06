package com.xinguoren.coolpen.cloud.web.spring.utils;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/2/24.
 */
public class Chef implements Runnable {
    private Restaurant restaurant;
    private int count = 0;

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void run() {
        try{
            while (!Thread.interrupted()){

                synchronized (this){
                    while(restaurant.meal != null)
                        wait();
                }

                if (++count == 10){
                    System.out.println("Out of food,closing");
                    restaurant.exec.shutdown();
                }
                System.out.println("Order up! ");

                synchronized (restaurant.waitPerson){
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(100);

            }

        }catch(Exception e){
                System.out.println("Chef interrupted");
        }
    }
}
