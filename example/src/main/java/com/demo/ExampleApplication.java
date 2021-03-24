package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScan(basePackages = {"com.demo.*"})
@MapperScan("com.demo.mapper")
public class ExampleApplication {

//    @Autowired
//    private StudentProducer kafkaSender;

    private static final Logger logger = LoggerFactory.getLogger(ExampleApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
    }

//    @PostConstruct
//    public void init(){
//        for (int i = 0; i < 10; i++) {
//            //调用消息发送类中的消息发送方法
//            kafkaSender.sendLog("1");
//        }
//    }
}
