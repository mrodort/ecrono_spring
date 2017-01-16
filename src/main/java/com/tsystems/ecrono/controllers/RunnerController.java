package com.tsystems.ecrono.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tsystems.ecrono.dto.Runner;

@RestController
@RequestMapping("runners")
public class RunnerController {

    @RequestMapping(method = RequestMethod.GET)
    public List<Runner> getRunners() {
	throw new IllegalArgumentException("Not implemented yet");
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Runner getRunnerById(@PathVariable("id://d+") Long runnerId) {
	throw new IllegalArgumentException("Not implemented yet");
    }

    @RequestMapping(method = RequestMethod.POST)
    public Runner createRunner() {
	throw new IllegalArgumentException("Not implemented yet");
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Runner editRunner(@PathVariable("id://d+") Long runnerId) {
	throw new IllegalArgumentException("Not implemented yet");
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public Void deleteRunner(@PathVariable("id://d+") Long runnerId) {
	throw new IllegalArgumentException("Not implemented yet");
    }

}
