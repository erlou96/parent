package com.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;

@TableName(value = "Score")
public class Score {
    @TableField(value = "s_id")
    private String StudentId;
    @TableField(value = "c_id")
    private String CourseId;
    @TableField(value = "s_score")
    private Integer score;

    public String getStudentId() {
        return StudentId;
    }

    public void setStudentId(String studentId) {
        StudentId = studentId;
    }

    public String getCourseId() {
        return CourseId;
    }

    public void setCourseId(String courseId) {
        CourseId = courseId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "StudentId='" + StudentId + '\'' +
                ", CourseId='" + CourseId + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
