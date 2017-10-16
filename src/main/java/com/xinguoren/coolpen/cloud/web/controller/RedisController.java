package com.xinguoren.coolpen.cloud.web.controller;

import com.xinguoren.coolpen.cloud.web.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * redisController
 */
@Controller
@RequestMapping(value = "/redis")
public class RedisController {
    @Autowired
    RedisService redisService;

    /**
     * 测试主界面
     * @return
     */
    @RequestMapping(value = "/index")
    public String all() {
        return "redis";
    }

    /**
     * redis分布式锁
     * @return
     */
    @RequestMapping(value = "/lock")
    @ResponseBody
    public Long lock() {
        return redisService.getLock();
    }

    /**
     * redis incr命令
     * @return
     */
    @RequestMapping(value = "/incr")
    @ResponseBody
    public String incr() {
        return  redisService.getCanAccess()?"访问成功":"5秒钟只能访问3次";
    }


}
