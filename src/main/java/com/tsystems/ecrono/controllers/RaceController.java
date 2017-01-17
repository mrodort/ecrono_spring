package com.tsystems.ecrono.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Race> getRaces() {
	return crudRaceUserCase.findAll();
    }

    @RequestMapping(value = "{id://d+}", method = RequestMethod.GET)
    public Race getRaceById(@PathVariable("id") Long raceId) {
	return crudRaceUserCase.getRaceById(raceId);
    }

    @RequestMapping(value = "{name}", method = RequestMethod.POST)
    public Race createRace(@RequestBody CreateRace createRace) {
	return crudRaceUserCase.createNewRace(createRace);
    }

    @RequestMapping(value = "{id://d+}", method = RequestMethod.PUT)
    public Race editRace(@PathVariable("id") Long raceId, @RequestBody UpdateRace updateRace) {
	return crudRaceUserCase.updateRace(raceId, updateRace);
    }

    @RequestMapping(value = "{id://d+}", method = RequestMethod.DELETE)
    public void deleteRace(@PathVariable("id") Long raceId) {
	crudRaceUserCase.deleteRace(raceId);
    }

}
