package com.xinguoren.coolpen.cloud.web.redis;

/**
 * Created by Administrator on 2017/1/10.
 */
public interface RedisClient {

    /**
     * 根据key获取值
     * @param key
     * @return
     */
    String strGet(String key);

    /**
     * 存储值
     * @param key
     * @param value
     * @return
     */
    String strSet(String key, String value);

    /**
     *获取hash
     * @param hkey
     * @param key
     * @return
     */
    String hashGet(String hkey, String key);

    /**
     * 存储hash
     * @param hkey
     * @param key
     * @param value
     * @return
     */
    void hashSet(String hkey, String key, String value);

    /**
     * 删除
     * @param key
     * @return
     */
    void del(String key);

    /**
     * hash 删除
     * @param hkey
     * @param key
     * @return
     */
    void hashDel(String hkey, String key);

    /**
     * 设置过期时间
     * @param key
     * @param second
     * @return
     */
    void expire(String key, int second);


    /**
     *
     * @param key
     * @param value
     * @param second
     */
    void expire(String key, String value, int second);


}
