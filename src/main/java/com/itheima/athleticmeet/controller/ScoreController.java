package com.itheima.athleticmeet.controller;

import com.itheima.athleticmeet.entity.Score;
import com.itheima.athleticmeet.service.ScoreService;
import com.itheima.athleticmeet.vo.ScoreRankVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scores")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    // 录入成绩
    @PostMapping
    public String addScore(@RequestBody Score score) {
        try {
            boolean success = scoreService.addScore(score);
            return success ? "成绩录入成功" : "成绩录入失败";
        } catch (Exception e) {
            return "成绩录入失败：" + e.getMessage();
        }
    }

    // 查询某项目成绩排名
    @GetMapping("/rank/{eventId}")
    public List<ScoreRankVO> getRank(@PathVariable Integer eventId) {
        return scoreService.getRankByEvent(eventId);
    }
}
