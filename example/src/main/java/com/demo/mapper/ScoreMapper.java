package com.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.common.vo.StudentScoreVo;
import com.demo.pojo.Score;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ScoreMapper extends BaseMapper<Score> {

    public List<StudentScoreVo> queryScoreList();
}
