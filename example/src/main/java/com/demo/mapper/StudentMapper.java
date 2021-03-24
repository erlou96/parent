package com.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.pojo.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public interface StudentMapper extends BaseMapper<Student> {

    public List<Student> queryStudentList();
}
