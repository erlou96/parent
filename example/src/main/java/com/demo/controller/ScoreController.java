package com.demo.controller;

import com.demo.common.vo.StudentScoreVo;
import com.demo.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping(value = "/pass")
    public List<StudentScoreVo> getScorePass() {
        List<StudentScoreVo> score = scoreService.getScore();
        return score;
    }
}
