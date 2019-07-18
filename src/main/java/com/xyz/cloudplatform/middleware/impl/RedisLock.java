package com.xyz.cloudplatform.middleware.impl;

import com.xyz.cloudplatform.middleware.DistributedLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Collections;
import java.util.UUID;

public class RedisLock implements DistributedLock{

    private static final Logger logger = LoggerFactory.getLogger(RedisLock.class);

    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    private String lockKey;
    private String lockValue;
    private JedisPool jedisPool;
    private Long milliseconds;


    public RedisLock(String lockKey, Long milliseconds, JedisPool jedisPool) {
        this.lockKey = lockKey;
        this.jedisPool = jedisPool;
        this.milliseconds = milliseconds;
    }


    /**
     * 加锁
     * @return
     */
    @Override
    public boolean getLock() {
        lockValue = UUID.randomUUID().toString();
        Jedis jedis = jedisPool.getResource();
        String result = jedis.set(lockKey, lockValue, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, milliseconds);
        jedis.close();
        return LOCK_SUCCESS.equals(result);
    }

    /**
     * 解锁
     */
    @Override
    public boolean releaseLock() {
        // 使用lua脚本进行分布式锁的解锁，保证操作原子性。
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Jedis jedis = jedisPool.getResource();
        long result = (long)jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(lockValue));
        logger.info("解锁返回结果："+result);
        jedis.close();
        return result==1;
    }

}
