package com.demo.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender {
    MALE(1, "男"),
    FEMALE(0, "女");

    Gender(Integer code, String gender) {
        this.gender = gender;
        this.code = code;
    }
    @JsonValue
    private String gender;
    @EnumValue
    private Integer code;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
