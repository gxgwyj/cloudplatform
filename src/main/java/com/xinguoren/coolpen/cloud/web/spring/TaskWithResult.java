package com.xinguoren.coolpen.cloud.web.spring;

import java.util.concurrent.Callable;

/**
 * Created by Administrator on 2017/2/23.
 */
public class TaskWithResult implements Callable<String> {
    private int id;
    public TaskWithResult(int id){
        this.id = id;
    }
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}
