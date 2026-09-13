package com.itheima.athleticmeet.service;

import com.itheima.athleticmeet.entity.Score;
import com.itheima.athleticmeet.mapper.ScoreMapper;
import com.itheima.athleticmeet.vo.ScoreRankVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;

    // 录入成绩：如果已存在则更新（可选逻辑），这里简单实现插入
    @Transactional
    public boolean addScore(Score score) {
        // 可以加校验：分数不能为负数等
        if (score.getScore() == null || score.getScore() < 0) {
            throw new IllegalArgumentException("成绩无效");
        }
        // 检查是否已经存在该运动员该项目的成绩（根据需求决定是更新还是拒绝）
        Score existing = scoreMapper.findByAthleteAndEvent(score.getAthleteId(), score.getEventId());
        if (existing != null) {
            // 已存在，可以抛异常或更新。这里简单抛异常
            throw new RuntimeException("该运动员在此项目中已有成绩，请使用更新接口");
        }
        int rows = scoreMapper.insert(score);
        return rows > 0;
    }

    // 获取项目排名
    public List<ScoreRankVO> getRankByEvent(Integer eventId) {
        return scoreMapper.getRankByEventId(eventId);
    }
}
