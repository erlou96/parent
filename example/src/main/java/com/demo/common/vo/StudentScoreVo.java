package com.demo.common.vo;

public class StudentScoreVo {

    private String studentId;
    private String studentName;
    private Double score;


    @Override
    public String toString() {
        return "ScoreModel{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", score=" + score +
                '}';
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
