package com.xyz.cloudplatform.middleware.impl;

import com.xyz.cloudplatform.middleware.DistributedLock;

public class ZooKeeperLock implements DistributedLock {
    @Override
    public boolean getLock() {
        return false;
    }

    @Override
    public boolean releaseLock() {
        return false;
    }
}
