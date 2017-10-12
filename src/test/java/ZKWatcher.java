import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * Created by Lenovo on 2017/7/29.
 */
public class ZKWatcher implements Watcher {

    public void process(WatchedEvent watchedEvent) {
        System.out.println("zookeeper node changed");
    }
}
