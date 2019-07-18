package com.xyz.cloudplatform;

import com.xyz.cloudplatform.redis.RedisClient;
import com.xyz.cloudplatform.redis.RedisLock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.JedisPool;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
        ({"/spring/applicationContext-redis.xml"})
public class RedisLockTest {

    private Logger logger = LoggerFactory.getLogger(RedisLockTest.class);

    @Autowired
    JedisPool jedisPool;

    @Autowired
    RedisClient redisClient;

    @Test
    public void testRedisLock() {

        RedisLock lock = new RedisLock("key1", 60 * 1000L, jedisPool);
        boolean lockFlag = lock.getLock();
        logger.info("加锁结果：" + lockFlag);
        boolean releaseLockFlag = lock.releaseLock();
        logger.info("解锁结果：" + releaseLockFlag);


    }

}
