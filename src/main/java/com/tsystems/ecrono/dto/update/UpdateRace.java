package com.tsystems.ecrono.dto.update;

import java.time.Instant;

import com.tsystems.ecrono.domain.component.RaceType;

import lombok.Data;

@Data
public class UpdateRace {

    private String name;
    private Float distanceInMeters;
    private Instant initTime;
    private RaceType type;

}
