package com.tsystems.ecrono.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tsystems.ecrono.dto.Runner;

@RestController
public class DorsalController {

    @RequestMapping(value = "races/{raceId}/runners/{runnerId}", method = RequestMethod.POST)
    public Runner createDorsal() {
	throw new IllegalArgumentException("Not implemented yet");
    }

    @RequestMapping(value = "races/{raceId}/runners/{runnerId}", method = RequestMethod.DELETE)
    public Void deleteDorsal(@PathVariable("raceId://d+") Long raceId, @PathVariable("runnerId://d+") Long runnerId) {
	throw new IllegalArgumentException("Not implemented yet");
    }
}
