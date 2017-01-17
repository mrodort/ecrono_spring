package com.tsystems.ecrono.dto.create;

import java.time.Instant;

import com.tsystems.ecrono.domain.component.RaceType;

import lombok.Data;

@Data
public class CreateRace {

    private String name;
    private Float distanceInMeters;
    private Instant initTime;
    private RaceType type;

}
