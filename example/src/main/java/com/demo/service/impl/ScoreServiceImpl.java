package com.demo.service.impl;

import com.demo.common.vo.StudentScoreVo;
import com.demo.mapper.ScoreMapper;
import com.demo.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;

    /**
     * 查询平均成绩及格学生信息
     * @return
     */
    @Override
    public List<StudentScoreVo> getScore() {
        List<StudentScoreVo> list = scoreMapper.queryScoreList();
        list.forEach(System.out::println);
        return list;
    }
}
