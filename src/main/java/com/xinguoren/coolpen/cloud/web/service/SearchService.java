package com.xinguoren.coolpen.cloud.web.service;

import com.xinguoren.coolpen.cloud.web.redis.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lenovo on 2017/3/7.
 */
@Service
public class SearchService {
    @Autowired
    RedisClient redisClient;
    public Long getLock(){
        Long result = redisClient.setnx("lock","1");
        if (result == 1L){
            redisClient.expire("lock",5);
        }
        return result;
    }
}
