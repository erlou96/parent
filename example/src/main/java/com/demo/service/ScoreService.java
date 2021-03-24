package com.demo.service;

import com.demo.common.vo.StudentScoreVo;

import java.util.List;

public interface ScoreService {
    public List<StudentScoreVo> getScore();
}
