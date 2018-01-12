package com.xyz.cloudplatform.controller;

import com.xyz.cloudplatform.service.RedisService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * redisController
 */
@Controller
@RequestMapping(value = "/redis")
public class RedisController {

    private static final Logger logger = Logger.getLogger(RedisController.class);

    @Autowired
    RedisService redisService;

    /**
     * redis主界面
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request) {
        logger.info(request.getSession().getId());
        redisService.setStr();
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
