package com.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "Course")
public class Course {
    @TableField(value = "c_id")
    private String courseId;
    @TableField(value = "c_id")
    private String courseName;
    @TableField(value = "t_id")
    private String teachId;

    public Course(String courseId, String courseName, String teachId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.teachId = teachId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", teachId='" + teachId + '\'' +
                '}';
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeachId() {
        return teachId;
    }

    public void setTeachId(String teachId) {
        this.teachId = teachId;
    }
}
