package com.xyz.cloudplatform.redis.impl;

import com.xyz.cloudplatform.redis.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by Administrator on 2017/1/10.
 */
@Component
public class RedisClientSingle implements RedisClient {

    @Autowired
    JedisPool  jedisPool;


    @Override
    public String get(String key) {
        Jedis  jedis = jedisPool.getResource();
        String str = jedis.get(key);
        jedis.close();
        return str;
    }

    @Override
    public String set(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        String str =  jedis.set(key, value);
        jedis.close();
        return str;
    }

    @Override
    public String hGet(String hkey, String key) {
        Jedis jedis = jedisPool.getResource();
        String str = jedis.hget(hkey, key);
        jedis.close();
        return str;
    }

    @Override
    public Long hSet(String hkey, String key, String value) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.hset(hkey, key, value);
        jedis.close();
        return result;
    }

    @Override
    public Long del(String key) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.del(key);
        jedis.close();
        return result;
    }

    @Override
    public Long hDel(String hkey, String key) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.hdel(hkey, key);
        jedis.close();
        return result;

    }

    @Override
    public Long expire(String key, int second) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.expire(key, second);
        jedis.close();
        return result;
    }

    @Override
    public Long setNx(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.setnx(key, value);
        jedis.close();
        return result;
    }
}
