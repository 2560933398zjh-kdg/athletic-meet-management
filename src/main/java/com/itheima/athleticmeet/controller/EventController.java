package com.itheima.athleticmeet.controller;

import com.itheima.athleticmeet.entity.Event;
import com.itheima.athleticmeet.mapper.EventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EventController {
    @Autowired
    private EventMapper eventMapper;

    @GetMapping("/events")
    public List<Event> getEvents() {
        return eventMapper.findAll();
    }
}
