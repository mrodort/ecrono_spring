package com.tsystems.ecrono.mapper;

import org.springframework.stereotype.Component;

import com.tsystems.ecrono.domain.DorsalEntity;
import com.tsystems.ecrono.dto.Competitor;

@Component
public class CompetitorMapper {

    public Competitor toCompetitor(DorsalEntity dorsalEntity) {
	Competitor competitor = new Competitor();
	competitor.setDorsalNumber(dorsalEntity.getDorsalNumber());
	competitor.setRunnerFullName(dorsalEntity.getRunner().getFullName());
	competitor.setRunnerId(dorsalEntity.getRunner().getId());
	return competitor;
    }

}
