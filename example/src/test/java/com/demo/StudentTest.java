package com.demo;

import com.demo.mapper.StudentMapper;
import com.demo.pojo.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<Student> userList = studentMapper.selectList(null);
        //Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }
}