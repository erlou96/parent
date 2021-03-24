package com.demo.service;

import com.demo.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {

    public Student queryStudentById(String id);

    public List<Student> queryStudentList();

    public List<Student> queryStudent();

    public List<Student> queryStudentByName(String name);
}
