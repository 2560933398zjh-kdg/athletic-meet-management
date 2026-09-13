package com.itheima.athleticmeet.service;

import com.itheima.athleticmeet.entity.Athlete;
import com.itheima.athleticmeet.mapper.AthleteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AthleteService {
    @Autowired
    private AthleteMapper athleteMapper;

    @Transactional
    public Athlete getAthleteById(Integer id) {
        return athleteMapper.findById(id);
    }

    @Transactional
    public List<Athlete> getAllAthletes() {
        return athleteMapper.findAll();
    }

    @Transactional
    public int modifyAthlete(Athlete athlete) {
        return athleteMapper.update(athlete);
    }

    @Transactional
    public int removeAthlete(Integer id) {
        return athleteMapper.deleteById(id);
    }

    public int addAthlete(Athlete athlete) {
        return athleteMapper.insert(athlete);
    }
}
