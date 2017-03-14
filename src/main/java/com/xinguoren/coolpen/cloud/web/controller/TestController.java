package com.xinguoren.coolpen.cloud.web.controller;

import com.xinguoren.coolpen.cloud.web.model.Blog;
import com.xinguoren.coolpen.cloud.web.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试controller
 * Created by Administrator on 2016/12/12.
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {
    @Autowired
    TestService testService;

    /**
     * 测试主界面
     * @return
     */
    @RequestMapping(value = "/all")
    public String all() {
        return "test";
    }

    @RequestMapping(value = "/test")
    @ResponseBody
    public Object test(@RequestBody Blog blog) {
        return blog;
    }

    /**
     * 测试redis分布式锁
     * @return
     */
    @RequestMapping(value = "/redis/lock")
    @ResponseBody
    public Long lock() {
        return testService.getLock();
    }

    /**
     * 测试redis incr命令
     * @return
     */
    @RequestMapping(value = "/redis/incr")
    @ResponseBody
    public String incr() {
        return  testService.getCanAccess()?"访问成功":"5秒钟只能访问3次";
    }


}
