package com.tsystems.ecrono.usercase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsystems.ecrono.domain.DorsalEntity;
import com.tsystems.ecrono.domain.RunnerEntity;
import com.tsystems.ecrono.dto.Dorsal;
import com.tsystems.ecrono.dto.create.CreateDorsal;
import com.tsystems.ecrono.mapper.DorsalMapper;
import com.tsystems.ecrono.repository.DorsalRepository;

@Service
public class CrudDorsalUserCase {

    private DorsalRepository dorsalRepository;
    private DorsalMapper mapper;

    @Autowired
    public CrudDorsalUserCase(DorsalRepository dorsalRepository, DorsalMapper mapper) {
	super();
	this.dorsalRepository = dorsalRepository;
	this.mapper = mapper;
    }

    public Dorsal createDorsal(Long raceId, Long runnerId, CreateDorsal createDorsal) throws DuplicateEntityException {
	RunnerEntity runner = new RunnerEntity();
	runner.setId(runnerId);
	DorsalEntity dorsalInBd = dorsalRepository.findByRaceIdAndRunner(raceId, runner);

	if (dorsalInBd == null) {
	    DorsalEntity dorsal = mapper.toDorsalEntity(raceId, runnerId, createDorsal);
	    dorsalRepository.save(dorsal);
	    return mapper.toDorsal(dorsal);
	} else {
	    throw new DuplicateEntityException("Ya existe el elemento con esas propiedades");
	}
    }

    public void deleteDorsal(Long raceId, Long runnerId) {
	// TODO eliminar bien
	// dorsalRepository.deleteByRaceIdAndRunner(raceId, runner);
    }

}
