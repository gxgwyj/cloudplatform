package com.xinguoren.coolpen.cloud.web.controller;

import com.xinguoren.coolpen.cloud.web.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping(value = "/my")
public class MyController {
    @Autowired
    RedisService redisService;

    /**
     * 测试主界面
     * @return
     */
    @RequestMapping(value = "/all")
    public String all() {
        return "test";
    }

    /**
     * 测试redis分布式锁
     * @return
     */
    @RequestMapping(value = "/redis/lock")
    @ResponseBody
    public Long lock() {
        return redisService.getLock();
    }

    /**
     * 测试redis incr命令
     * @return
     */
    @RequestMapping(value = "/redis/incr")
    @ResponseBody
    public String incr() {
        return  redisService.getCanAccess()?"访问成功":"5秒钟只能访问3次";
    }


}
