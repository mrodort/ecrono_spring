package com.tsystems.ecrono.mapper;

import org.springframework.stereotype.Component;

import com.tsystems.ecrono.domain.RunnerEntity;
import com.tsystems.ecrono.dto.Runner;
import com.tsystems.ecrono.dto.create.CreateRunner;
import com.tsystems.ecrono.dto.update.UpdateRunner;

@Component
public class RunnerMapper {

    public Runner toRunner(RunnerEntity runnerToReturn) {
	Runner target = new Runner();
	target.setFullName(runnerToReturn.getFullName());
	target.setId(runnerToReturn.getId());
	return target;
    }

    public RunnerEntity toRunnerEntity(CreateRunner createRunner) {
	RunnerEntity runnerToCreate = new RunnerEntity();
	runnerToCreate.setFullName(createRunner.getFullName());
	return runnerToCreate;
    }

    public RunnerEntity updateRunnerEntity(UpdateRunner createRunner, RunnerEntity runnerToCreate) {
	runnerToCreate.setFullName(createRunner.getFullName());
	return runnerToCreate;
    }

}
