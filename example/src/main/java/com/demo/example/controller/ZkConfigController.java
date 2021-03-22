package com.demo.example.controller;

import com.demo.service.ZkConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 读取common目录下的配置文件
 *
 */
@RestController
@RequestMapping(value = "/config")
public class ZkConfigController {

    @Autowired
    private ZkConfigService zkConfigService;

    /**
     * 模拟读取配置文件配置了项的请求
     * @return
     */
    @GetMapping(value = "/zookeeper-quorum")
    public String getZookeeperQuorum() {
        String zookeeperQuorum = zkConfigService.getZookeeperQuorum();
        return zookeeperQuorum;
    }

    /**
     * 模拟读取配置文件没有配置项的请求，使用@Value默认的值
     * @return
     */
    @GetMapping(value = "/zookeeper-name")
    public String getZookeeperName() {
        String zookeeperName = zkConfigService.getZookeeperName();
        return zookeeperName;
    }
}
