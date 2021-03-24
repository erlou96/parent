package com.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 随着springboot启动提前初始化，并且只会调用一次
 */
@Component
@PropertySource("classpath:common/testFile.properties")
public class Test implements InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(Test.class);
    @Value("${hdfs.user.root}")
    private String hdfs;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("在启动springboot 之前执行");
    }

    private static Properties properties = new Properties();
    static {
        InputStream resourceAsStream =
                Test.class.getResourceAsStream("/common/testFile.properties");
        try {
            properties.load(resourceAsStream);
            System.out.println("从配置文件中读取"+properties.get("hdfs.user.root"));
            logger.info("didi");
        }catch (IOException ioe){
            ioe.printStackTrace();
        }finally{

        }
    }

    public String getHdfs() {
        return hdfs;
    }

    public void setHdfs(String hdfs) {
        this.hdfs = hdfs;
    }
}
