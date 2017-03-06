package com.xinguoren.coolpen.cloud.web.spring.utils;

/**
 * 厨房
 * Created by Administrator on 2017/2/24.
 */
public class Meal {
    private final int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "orderNum=" + orderNum +
                '}';
    }
}
