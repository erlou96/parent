package sdk.zk;

import org.apache.curator.framework.CuratorFramework;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CuratorZookeeperClient implements InitializingBean {

    @Autowired
    private ZookeeperConfig zookeeperConfig;

    private CuratorFramework client;

    public void afterPropertiesSet() throws Exception {
    }

//    public CuratorFramework buildClient(){
//        CuratorFrameworkFactory.Builder builder = CuratorFrameworkFactory.builder().ensembleProvider(new DefaultEnsembleProvider(zookeeperConfig.getServerList()))
//                .retryPolicy(new ExponentialBackoffRetry(zookeeperConfig.getSessionTimeoutMs(), zookeeperConfig.getMaxRetries(), zookeeperConfig.getMaxSleepMs()));
//        builder.sessionTimeoutMs(zookeeperConfig.getSessionTimeoutMs());
//        builder.au
//    }
}
