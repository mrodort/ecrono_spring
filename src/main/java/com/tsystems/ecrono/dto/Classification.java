package com.tsystems.ecrono.dto;

import java.time.Instant;

import lombok.Data;

@Data
public class Classification {

    public Long runnerId;
    public String runnerFullName;
    public int dorsalNumber;
    public Instant time;

}
