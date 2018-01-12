import org.apache.zookeeper.ZooKeeper;

/**
 * Created by Lenovo on 2017/7/23.
 */
public class ZkActionTest {

    public static void main(String[] args) throws Exception{
        ZooKeeper zooKeeper = ZooKeeperClientFactoryTest.getZkInstance();
        zooKeeper.getChildren("/wwwww",new ZKWatcherTest());
//        String result = zooKeeper.create("/wwwww", "gaoxugang data".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//        System.out.println(result);
        while (true){

        }

    }
}
