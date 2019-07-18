package com.xyz.cloudplatform.middleware;

public interface DistributedLock {
    /**
     * 获取锁
     * @return
     */
    public boolean getLock();

    /**
     * 解锁
     */
    public boolean releaseLock();
}
