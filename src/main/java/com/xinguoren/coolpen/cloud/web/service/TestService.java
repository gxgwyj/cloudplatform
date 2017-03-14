package com.xinguoren.coolpen.cloud.web.service;

import com.xinguoren.coolpen.cloud.web.redis.RedisClient;
import com.xinguoren.coolpen.cloud.web.redis.impl.RedisHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lenovo on 2017/3/7.
 */
@Service
public class TestService {
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
}
