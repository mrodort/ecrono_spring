package com.tsystems.ecrono.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tsystems.ecrono.dto.Classification;
import com.tsystems.ecrono.usercase.ClassificationUserCase;

@Controller
@RequestMapping(value = "classificationpage/{raceId}")
public class ClassificationPageControler {

    private final ClassificationUserCase classificationUserCase;

    @Autowired
    public ClassificationPageControler(ClassificationUserCase classificationUserCase) {
	super();
	this.classificationUserCase = classificationUserCase;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getClassification(@PathVariable("raceId") Long raceId, Model model) {
	List<Classification> classification = classificationUserCase.getClassification(raceId);

	model.addAttribute("nombre1", classification);
	model.addAttribute("nombre2", classification);

	model.addAttribute("mensaje", "hola!!");

	return "classification";
    }

}
