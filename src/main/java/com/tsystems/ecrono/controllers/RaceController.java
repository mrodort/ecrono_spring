package com.tsystems.ecrono.controllers;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tsystems.ecrono.domain.component.RaceType;
import com.tsystems.ecrono.dto.Race;
import com.tsystems.ecrono.dto.create.CreateRace;
import com.tsystems.ecrono.dto.update.UpdateRace;
import com.tsystems.ecrono.usercase.CrudRaceUserCase;

@RestController
@RequestMapping("races")
public class RaceController {

    private CrudRaceUserCase crudRaceUserCase;

    @Autowired
    public RaceController(CrudRaceUserCase crudRaceUserCase) {
	super();
	this.crudRaceUserCase = crudRaceUserCase;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Race> getRaces(@RequestParam(value = "filterType", required = false) RaceType filterType,
	    @RequestParam(value = "filterDate", required = false) //
	    @DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss.SSSZ") //
	    Instant filterDate) {
	return crudRaceUserCase.findAll(filterType, filterDate);
    }

    @RequestMapping(value = "{id:\\d+}", method = RequestMethod.GET)
    public Race getRaceById(@PathVariable("id") Long raceId) {
	return crudRaceUserCase.getRaceById(raceId);
    }

    @RequestMapping(value = "{name}", method = RequestMethod.POST)
    public ResponseEntity<Race> createRace(@RequestBody CreateRace createRace) {
	return new ResponseEntity<Race>(crudRaceUserCase.createNewRace(createRace), HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id:\\d+}", method = RequestMethod.PUT)
    public Race editRace(@PathVariable("id") Long raceId, @RequestBody UpdateRace updateRace) {
	return crudRaceUserCase.updateRace(raceId, updateRace);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteRace(@PathVariable("id") Long raceId) {
	crudRaceUserCase.deleteRace(raceId);
    }

}
