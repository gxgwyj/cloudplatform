package com.xinguoren.coolpen.cloud.junit;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

/**
 * Created by Lenovo on 2017/7/23.
 */
public class ZkAction {

    public static void main(String[] args) throws Exception{
        ZooKeeper zooKeeper = ZooKeeperClientFactory.getZkInstance();
        zooKeeper.getChildren("/wwwww",new ZKWatcher());
//        String result = zooKeeper.create("/wwwww", "gaoxugang data".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//        System.out.println(result);
        while (true){

        }

    }
}
