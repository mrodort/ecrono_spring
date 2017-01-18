package com.tsystems.ecrono.usercase;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsystems.ecrono.domain.RunnerEntity;
import com.tsystems.ecrono.dto.Runner;
import com.tsystems.ecrono.dto.create.CreateRunner;
import com.tsystems.ecrono.dto.update.UpdateRunner;
import com.tsystems.ecrono.mapper.RunnerMapper;
import com.tsystems.ecrono.repository.RunnerRepository;

@Service
public class CrudRunnerUserCase {

    private final RunnerRepository runnerRepository;
    private final RunnerMapper mapper;

    @Autowired
    public CrudRunnerUserCase(RunnerRepository runnerRepository, RunnerMapper mapper) {
	super();
	this.runnerRepository = runnerRepository;
	this.mapper = mapper;
    }

    public Runner getRunnerById(Long runnerId) {

	RunnerEntity runnerToReturn = runnerRepository.findOne(runnerId);
	Runner target = mapper.toRunner(runnerToReturn);

	return target;
    }

    public Runner createNewRunner(CreateRunner createRunner) {

	RunnerEntity runnerToCreate = mapper.toRunnerEntity(createRunner);
	runnerRepository.save(runnerToCreate);

	return mapper.toRunner(runnerToCreate);
    }

    public Runner updateRunner(Long idRunner, UpdateRunner updateRunner) {

	RunnerEntity runnerToUpdate = runnerRepository.findOne(idRunner);
	mapper.updateRunnerEntity(updateRunner, runnerToUpdate);

	return mapper.toRunner(runnerToUpdate);
    }

    public List<Runner> findAll(String filterName) {
	List<Runner> listToReturn;
	List<RunnerEntity> runnerList;

	if (filterName == null) {
	    runnerList = runnerRepository.findAll();
	} else {
	    runnerList = runnerRepository.findByFullNameContains(filterName);
	}

	listToReturn = new LinkedList<>();
	for (RunnerEntity runner : runnerList) {
	    listToReturn.add(mapper.toRunner(runner));
	}

	return listToReturn;

	/*
	 * return runnerList.parallelStream()// .map(r -> mapper.toRunner(r))//
	 * STREAM JAVA .collect(Collectors.toList());
	 */
    }

    public void delete(Long runnerId) {
	runnerRepository.delete(runnerId);
    }
}
