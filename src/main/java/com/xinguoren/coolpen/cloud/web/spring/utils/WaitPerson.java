package com.xinguoren.coolpen.cloud.web.spring.utils;

/**
 * Created by Administrator on 2017/2/24.
 */
public class WaitPerson implements Runnable {
    private Restaurant restaurant;
    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    public void run() {
        try{
            while(!Thread.interrupted()){

                synchronized (this){
                    while(restaurant.meal == null)
                        wait();
                }

                System.out.println("Waitperson got " + restaurant.meal);

                synchronized (restaurant.chef){
                    restaurant.meal = null;
                    restaurant.chef.notifyAll();
                }

            }

        }catch (InterruptedException e){
            System.out.println("Waitperson interrupted ");
        }

    }
}
