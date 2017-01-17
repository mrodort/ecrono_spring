package com.tsystems.ecrono.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tsystems.ecrono.dto.Runner;
import com.tsystems.ecrono.dto.create.CreateRunner;
import com.tsystems.ecrono.dto.update.UpdateRunner;
import com.tsystems.ecrono.usercase.CrudRunnerUserCase;

@RestController
@RequestMapping("runners")
public class RunnerController {

    private final CrudRunnerUserCase crudRunnerUserCase;

    @Autowired
    public RunnerController(CrudRunnerUserCase crudRunnerUserCase) {
	super();
	this.crudRunnerUserCase = crudRunnerUserCase;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Runner> getRunners() {
	return crudRunnerUserCase.findAll();
    }

    @RequestMapping(value = "{id:\\d+}", method = RequestMethod.GET)
    public Runner getRunnerById(@PathVariable("id") Long runnerId) {
	return crudRunnerUserCase.getRunnerById(runnerId);
    }

    @RequestMapping(value = "{fullName}", method = RequestMethod.POST)
    public Runner createRunner(@RequestBody CreateRunner createRunner) {
	return crudRunnerUserCase.createNewRunner(createRunner);
    }

    @RequestMapping(value = "{id:\\d+}", method = RequestMethod.PUT)
    public Runner editRunner(@PathVariable("id") Long runnerId, @RequestBody UpdateRunner updateRunner) {
	return crudRunnerUserCase.updateRunner(runnerId, updateRunner);
    }

    @RequestMapping(value = "{id:\\d+}", method = RequestMethod.DELETE)
    public void deleteRunner(@PathVariable("id") Long runnerId) {
	crudRunnerUserCase.delete(runnerId);
    }

}
