package com.itheima.athleticmeet.entity;

import lombok.Data;

@Data
public class Score {
    private Integer athleteId;
    private Integer eventId;
    private Double score;
}
