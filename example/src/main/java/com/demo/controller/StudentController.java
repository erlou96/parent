package com.demo.controller;

import com.demo.pojo.Student;
import com.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 根据id来返回学生 使用的是@PathVariable
     * eg: /student/1
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public Student queryStudentById(@PathVariable String id) {
        Student student = studentService.queryStudentById(id);
        return student;
    }

    /**
     * 根据自带的wrapper接口查询
     * @return
     */
    @GetMapping(value = "/")
    public List<Student> getStudent() {
        List<Student> students = studentService.queryStudent();
        return students;
    }

    /**
     * 根据自己编写的xml来查询
     * @return
     */
    @GetMapping(value = "/list")
    public List<Student> getStudentList() {
        List<Student> students = studentService.queryStudentList();
        return students;
    }

    /**
     * 根据姓名查找学生
     * eg: /student/like?name=王
     * @param name
     * @return
     */
    @GetMapping(value = "/like")
    public List<Student> queryById(@RequestParam(value = "name") String name) {
        List<Student> students = studentService.queryStudentByName(name);
        return students;
    }

}
