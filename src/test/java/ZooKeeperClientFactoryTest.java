import org.apache.zookeeper.ZooKeeper;

/**
 * Created by Lenovo on 2017/7/23.
 */
public class ZooKeeperClientFactoryTest {
    private static String HOST = "192.168.204.134:2181";

    private ZooKeeperClientFactoryTest(){}

    private static class ZkClient{
        public static ZooKeeper  zooKeeper = createZooKeeper();

        public static ZooKeeper  createZooKeeper(){
            try {
                return  new ZooKeeper(HOST,6000,null);
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }
    }


    public static ZooKeeper getZkInstance(){
        return ZkClient.zooKeeper;
    }




}
