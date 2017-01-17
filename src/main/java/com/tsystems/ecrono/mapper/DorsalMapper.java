package com.tsystems.ecrono.mapper;

import org.springframework.stereotype.Component;

import com.tsystems.ecrono.domain.DorsalEntity;
import com.tsystems.ecrono.domain.RunnerEntity;
import com.tsystems.ecrono.dto.Dorsal;
import com.tsystems.ecrono.dto.create.CreateDorsal;

@Component
public class DorsalMapper {

    public DorsalEntity toDorsalEntity(Long raceId, Long runnerId, CreateDorsal createDorsal) {

	DorsalEntity target = new DorsalEntity();
	target.setChipCode(createDorsal.getChipCode());
	target.setDorsalNumber(createDorsal.getDorsalNumber());
	target.setRaceId(raceId);

	RunnerEntity runner = new RunnerEntity();
	runner.setId(runnerId);
	target.setRunner(runner);

	return target;
    }

    public Dorsal toDorsal(DorsalEntity dorsalEntity) {

	Dorsal dorsal = new Dorsal();

	dorsal.setChipCode(dorsalEntity.getChipCode());
	dorsal.setDorsalNumber(dorsalEntity.getDorsalNumber());
	dorsal.setRaceId(dorsalEntity.getRaceId());
	dorsal.setRunnerId(dorsalEntity.getRunner().getId());

	return dorsal;
    }

}
