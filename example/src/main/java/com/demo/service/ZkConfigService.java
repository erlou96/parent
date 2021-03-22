package com.demo.service;

import com.demo.config.ZkConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZkConfigService {

    @Autowired
    private ZkConfig zkConfig;

    public String getZookeeperQuorum() {
        String quorum = zkConfig.getQuorum();
        return quorum;
    }
    public String getZookeeperName() {
        String zookeeperName = zkConfig.getZookeeperName();
        return zookeeperName;
    }
}
