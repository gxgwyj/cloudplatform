package com.xyz.cloudplatform.redis.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


/**
 * redis 防刷工具,指定的时间内，可以操作的次数
 * Created by Administrator on 2017/3/9.
 */
@Component
public class RedisHandler {
    @Autowired
    JedisPool jedisPool;

    /**
     *是否可以
     * @param key  key
     * @param exceedTime  限制次数
     * @param losetime    失效时间
     * @return
     */
    public boolean canAccess(String key,int exceedTime,int losetime){
        try{
            Jedis  jedis = jedisPool.getResource();
            long count = jedis.incrBy(key,1);
            if (count == 1){
                jedis.expire(key,losetime);
            }
            jedis.close();
            if (count > exceedTime){
                return false;
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return true;
        }

    }
}
