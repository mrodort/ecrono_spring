package com.tsystems.ecrono.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tsystems.ecrono.dto.Competitor;
import com.tsystems.ecrono.usercase.CompetitorUserCase;

@RestController
@RequestMapping(value = "/races/{raceId:\\d+}/competitors")
public class CompetitorController {

    private final CompetitorUserCase competitorUserCase;

    public CompetitorController(CompetitorUserCase competitorUserCase) {
	super();
	this.competitorUserCase = competitorUserCase;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Competitor> getCompetitor(@PathVariable("raceId") Long raceId) {
	return this.competitorUserCase.getCompetitors(raceId);
    }
}
