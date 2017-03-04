package com.xinguoren.coolpen.cloud.web.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by Lenovo on 2017/3/4.
 */
public class JedisTest {

    @Test
    public void jedisSingleTest(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-redis.xml");
        JedisPool pool = ctx.getBean(JedisPool.class);
        Jedis jedis = pool.getResource();
        String result = jedis.set("id","10086");
        System.out.println(result);
        jedis.close();
        pool.close();

    }
}
