package com.tsystems.ecrono.mapper;

import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.tsystems.ecrono.domain.RaceEntity;
import com.tsystems.ecrono.domain.component.RaceType;
import com.tsystems.ecrono.dto.Race;
import com.tsystems.ecrono.dto.create.CreateRace;
import com.tsystems.ecrono.dto.update.UpdateRace;

@Component
public class RaceMapper {

    public Race toRace(RaceEntity raceToReturn) {
	Race target = new Race();
	target.setId(raceToReturn.getId());
	target.setName(raceToReturn.getName());
	target.setDistanceInMeters(raceToReturn.getDistanceInMeters());
	target.setType(raceToReturn.getType());

	String formatDate = DateTimeFormatter.ISO_DATE_TIME.format(raceToReturn.getInitTime());
	target.setInitTime(formatDate);
	return target;
    }

    public RaceEntity toRaceEntity(CreateRace createRace) {
	RaceEntity raceToCreate = new RaceEntity();
	raceToCreate.setName(createRace.getName());
	raceToCreate.setDistanceInMeters(createRace.getDistanceInMeters());
	raceToCreate.setType(toRaceType(createRace.getDistanceInMeters()));
	raceToCreate.setInitTime(createRace.getInitTime());
	return raceToCreate;
    }

    private RaceType toRaceType(Float distanceInMeters) {
	if (distanceInMeters <= 100) {
	    return RaceType.SPRINT;
	} else if (distanceInMeters <= 21000) {
	    return RaceType.HALF_MARATHON;
	} else if (distanceInMeters <= 42000) {
	    return RaceType.MARATHON;
	} else
	    return RaceType.IRON_MAN;
    }

    public RaceEntity updateRaceEntity(UpdateRace updateRace, RaceEntity raceToUpdate) {
	raceToUpdate.setName(updateRace.getName());
	raceToUpdate.setDistanceInMeters(updateRace.getDistanceInMeters());
	raceToUpdate.setType(updateRace.getType());
	raceToUpdate.setInitTime(updateRace.getInitTime());
	return raceToUpdate;
    }

}