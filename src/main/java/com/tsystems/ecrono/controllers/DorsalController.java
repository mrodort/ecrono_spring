package com.tsystems.ecrono.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tsystems.ecrono.dto.Dorsal;
import com.tsystems.ecrono.dto.create.CreateDorsal;
import com.tsystems.ecrono.mapper.DorsalMapper;
import com.tsystems.ecrono.usercase.CrudDorsalUserCase;
import com.tsystems.ecrono.usercase.DuplicateEntityException;

@RestController
@RequestMapping(value = "races/{raceId}/runners/{runnerId}/dorsals")
public class DorsalController {

    private final CrudDorsalUserCase crudDorsalUserCase;

    public DorsalController(CrudDorsalUserCase crudDorsalUserCase, DorsalMapper mapper) {
	super();
	this.crudDorsalUserCase = crudDorsalUserCase;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Dorsal> createDorsal(@PathVariable(value = "runnerId") Long runnerId,
	    @PathVariable(value = "raceId") Long raceId, @RequestBody CreateDorsal createDorsal) {

	try {
	    Dorsal created = crudDorsalUserCase.createDorsal(raceId, runnerId, createDorsal);
	    return new ResponseEntity<Dorsal>(created, HttpStatus.CREATED);
	} catch (DuplicateEntityException e) {
	    return new ResponseEntity<Dorsal>(HttpStatus.CONFLICT);
	}
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteDorsal(@PathVariable("raceId") Long raceId, @PathVariable("runnerId") Long runnerId) {
	crudDorsalUserCase.deleteDorsal(raceId, runnerId);
    }
}
