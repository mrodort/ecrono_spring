package com.tsystems.ecrono.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tsystems.ecrono.dto.Classification;
import com.tsystems.ecrono.usercase.ClassificationUserCase;

@RestController
@RequestMapping(value = "races/{raceId:\\d+}/classification")
public class ClassificationController {

    private final ClassificationUserCase classificationUserCase;

    @Autowired
    public ClassificationController(ClassificationUserCase classificationUserCase) {
	super();
	this.classificationUserCase = classificationUserCase;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Classification> getClassification(@PathVariable("raceId") Long raceId) {
	return classificationUserCase.getClassification(raceId);
    }

}
