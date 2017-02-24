package com.xinguoren.coolpen.cloud.web.spring.utils;

import com.xinguoren.coolpen.cloud.web.spring.MyTask1;
import com.xinguoren.coolpen.cloud.web.spring.MyTask2;

/**
 * Created by Administrator on 2017/2/23.
 */
public class AppRun {
    public static void main(String[] args) {
        MyTask1 myTask1_1 = new MyTask1("myTask1_1",15000);
        MyTask1 myTask1_2 = new MyTask1("myTask1_2",15000);

        MyTask2 myTask2_1 = new MyTask2("myTask2_1",myTask1_1);
        MyTask2 myTask2_2 = new MyTask2("myTask2_2",myTask1_2);

//        myTask1_2.interrupt();

    }
}
