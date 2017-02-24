package com.xinguoren.coolpen.cloud.web.spring.utils;

/**
 * Created by Administrator on 2017/2/23.
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;
    public abstract int next();
    public void cancel(){
        canceled = true;
    }
    public boolean isCanceled(){
        return canceled;

    }
}
