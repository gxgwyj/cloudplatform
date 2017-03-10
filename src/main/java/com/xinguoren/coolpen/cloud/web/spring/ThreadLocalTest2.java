package com.xinguoren.coolpen.cloud.web.spring;

import java.util.Random;

/**
 * Created by Administrator on 2017/3/10.
 */
public class ThreadLocalTest2 {

    public final static ThreadLocal <String>TEST_THREAD_NAME_LOCAL = new ThreadLocal<String>();

    public final static ThreadLocal <String>TEST_THREAD_VALUE_LOCAL = new ThreadLocal<String>();

    public static void main(String[] args) {
        for(int i = 0 ; i < 100 ; i++) {
            final String name = "线程-【" + i + "】";
            final String value =  String.valueOf(i);
            new Thread() {
                public void run() {
                    try {
                        TEST_THREAD_NAME_LOCAL.set(name);
                        TEST_THREAD_VALUE_LOCAL.set(value);
                        callA();
                    }finally {
                        TEST_THREAD_NAME_LOCAL.remove();
                        TEST_THREAD_VALUE_LOCAL.remove();
                    }
                }
            }.start();
        }
    }
    public static void callA() {
        callB();
    }

    public static void callB() {
        new ThreadLocalTest2().callC();
    }

    public void callC() {
        callD();
    }

    public void callD() {
        System.out.println(TEST_THREAD_NAME_LOCAL.get() + "\t=\t" + TEST_THREAD_VALUE_LOCAL.get());
    }

}
