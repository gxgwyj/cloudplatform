package com.xinguoren.coolpen.cloud.web.redis.impl;

import com.xinguoren.coolpen.cloud.web.redis.RedisClient;
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


    public String strGet(String key) {
        try {
            Jedis  jedis = jedisPool.getResource();
            String str = jedis.get(key);
            jedis.close();
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String strSet(String key, String value) {
        try {
            Jedis jedis = jedisPool.getResource();
            String str =  jedis.set(key, value);
            jedis.close();
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String hashGet(String hkey, String key) {
        try {
            Jedis jedis = jedisPool.getResource();
            String str = jedis.hget(hkey, key);
            jedis.close();
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void hashSet(String hkey, String key, String value) {
        try {
            Jedis jedis = jedisPool.getResource();
            jedis.hset(hkey, key, value);
            jedis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void del(String key) {
        try {
            Jedis jedis = jedisPool.getResource();
            jedis.del(key);
            jedis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hashDel(String hkey, String key) {
        try {
            Jedis jedis = jedisPool.getResource();
            jedis.hdel(hkey, key);
            jedis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void expire(String key, int second) {
        try {
            Jedis jedis = jedisPool.getResource();
            jedis.expire(key, second);
            jedis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void expire(String key,String value,  int second) {
        try {
            Jedis jedis = jedisPool.getResource();
            this.strSet(key, value);
            jedis.expire(key, second);
            jedis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
