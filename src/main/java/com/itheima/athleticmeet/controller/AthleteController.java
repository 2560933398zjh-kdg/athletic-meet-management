package com.itheima.athleticmeet.controller;

import com.itheima.athleticmeet.entity.Athlete;
import com.itheima.athleticmeet.service.AthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/athletes")
public class AthleteController {
    @Autowired
    private AthleteService athleteService;

    @GetMapping("/{id}")
    public Athlete getById(@PathVariable Integer id) {
        return athleteService.getAthleteById(id);
    }

    @GetMapping
    public List<Athlete> getAll() {
        return athleteService.getAllAthletes();
    }

    // 新增运动员
    @PostMapping
    public String add(@RequestBody Athlete athlete) {
        int rows = athleteService.addAthlete(athlete);
        return rows > 0 ? "添加成功" : "添加失败";
    }

    // 修改运动员（通过请求体传入完整对象，必须包含id）
    @PutMapping
    public String update(@RequestBody Athlete athlete) {
        int rows = athleteService.modifyAthlete(athlete);
        return rows > 0 ? "更新成功" : "更新失败";
    }

    // 删除运动员
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        int rows = athleteService.removeAthlete(id);
        return rows > 0 ? "删除成功" : "删除失败";
    }
}
