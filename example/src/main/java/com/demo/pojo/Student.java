package com.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.demo.common.enums.Gender;

import java.io.Serializable;
import java.util.function.Consumer;

@TableName(value = "Student")
public class Student implements Serializable {
    @TableId(value = "s_id")
    private String id;
    @TableField(value = "s_name")
    private String name;
    @TableField(value = "s_birth")
    private String birth;
    @TableField(value = "s_sex")
    private Gender sex;


    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    public Student(String id, String name, String birth, Gender sex) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.sex = sex;
    }
}
