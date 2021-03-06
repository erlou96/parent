package com.demo.kafka;


import com.alibaba.fastjson.JSON;
import com.demo.common.enums.Gender;
import com.demo.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class StudentProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendLog(String userid){
        Student student = new Student("1","zhangsan","2020-10-01", Gender.FEMALE);
        System.err.println("发送用户日志数据:"+student);
        // kafkaTemplate.send("test", JSON.toJSONString(student));
        kafkaTemplate.send("test_key",userid,JSON.toJSONString(student));
    }

}
