package com.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 读取common/zookeeper.properties的配置文件
 */
@Configuration
@Component
@PropertySource("classpath:common/zookeeper.properties")
public class ZkConfig {
    private static final Logger logger = LoggerFactory.getLogger(ZkConfig.class);

    @Value("${zookeeper.quorum:127.0.0.1}")
    private String quorum;

    @Value("${zookeeper.dolphinscheduler.root:/test}")
    private String dolphinschedulerRoot;

    @Value("${zookeeper.name:测试集群}")
    private String zookeeperName;

    public String getQuorum() {
        return quorum;
    }

    public void setQuorum(String quorum) {
        this.quorum = quorum;
    }

    public String getDolphinschedulerRoot() {
        return dolphinschedulerRoot;
    }

    public void setDolphinschedulerRoot(String dolphinschedulerRoot) {
        this.dolphinschedulerRoot = dolphinschedulerRoot;
    }

    public String getZookeeperName() {
        return zookeeperName;
    }

    public void setZookeeperName(String zookeeperName) {
        this.zookeeperName = zookeeperName;
    }
}
