package com.xinguoren.coolpen.cloud.web.service;

import com.xinguoren.coolpen.cloud.web.redis.RedisClient;
import com.xinguoren.coolpen.cloud.web.redis.impl.RedisHandler;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lenovo on 2017/3/7.
 */
@Service
public class RedisService {
    private final static Logger logger = Logger.getLogger(RedisService.class);
    @Autowired
    RedisClient redisClient;
    @Autowired
    RedisHandler redisHandler;
    public Long getLock(){
        Long result = redisClient.setnx("lock","1");
        if (result == 1L){
            redisClient.expire("lock",5);
        }
        return result;
    }
    public boolean getCanAccess(){
        return redisHandler.canAccess("acc",3,5);
    }

    public void setStr(){
        logger.info("redis set");
        redisClient.strSet("redisTest","redisTest");
    }
}
