package com.demo.pojo;

import java.io.Serializable;
import java.util.function.Consumer;

public class Student implements Serializable {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Student stu = new Student("zhangsan",13);
        Consumer<Student> consumer = student -> {
            student.setAge(19);
            student.setName("wangwu");
        };
        consumer.accept(stu);

        System.out.println(stu.getAge());
    }
}
