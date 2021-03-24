package com.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.demo.mapper.StudentMapper;
import com.demo.pojo.Student;
import com.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student queryStudentById(String id) {

        Student student = studentMapper.selectById(id);
        return student;
    }

    public List<Student> queryStudentList() {
        List<Student> students = studentMapper.queryStudentList();
        return students;
    }
    public List<Student> queryStudent() {
        List<Student> students = studentMapper.selectList(null);
        return students;
    }

    public List<Student> queryStudentByName(String name) {
        List<Student> s_id = studentMapper.selectList(new QueryWrapper<Student>().like("s_name", name));
        return s_id;
    }
}
