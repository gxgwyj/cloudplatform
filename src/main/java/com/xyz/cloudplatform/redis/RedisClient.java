package com.xyz.cloudplatform.redis;

/**
 * Created by Administrator on 2017/1/10.
 */
public interface RedisClient {

    /**
     * 根据key获取值
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 存储值
     * @param key
     * @param value
     * @return
     */
    String set(String key, String value);

    /**
     *获取hash
     * @param hkey
     * @param key
     * @return
     */
    String hGet(String hkey, String key);

    /**
     * 存储hash
     * @param hkey
     * @param key
     * @param value
     * @return
     */
    Long hSet(String hkey, String key, String value);

    /**
     * 删除
     * @param key
     * @return
     */
    Long del(String key);

    /**
     * hash 删除
     * @param hkey
     * @param key
     * @return
     */
    Long hDel(String hkey, String key);

    /**
     * 设置过期时间
     * @param key
     * @param seconds
     * @return
     */
    Long expire(String key, int seconds);

    Long setNx(String key,String value);


}
