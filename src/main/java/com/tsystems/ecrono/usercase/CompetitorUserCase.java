package com.tsystems.ecrono.usercase;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsystems.ecrono.domain.DorsalEntity;
import com.tsystems.ecrono.dto.Competitor;
import com.tsystems.ecrono.mapper.CompetitorMapper;
import com.tsystems.ecrono.repository.DorsalRepository;

@Service
public class CompetitorUserCase {

    private final DorsalRepository dorsalRepository;
    // private final CompetitorMapper mapper;

    @Autowired
    public CompetitorUserCase(DorsalRepository dorsalrepository, CompetitorMapper mapper) {
	super();
	this.dorsalRepository = dorsalrepository;
	// this.mapper = mapper;
    }

    public List<Competitor> getCompetitors(Long raceId) {

	List<DorsalEntity> dorsals = dorsalRepository.findByRaceId(raceId);

	List<Competitor> resultList = new LinkedList<>();
	for (DorsalEntity dorsalEntity : dorsals) {
	    // Competitor competitor = mapper.toCompetitor(dorsalEntity);
	    Competitor competitor = new Competitor();
	    competitor.setDorsalNumber(dorsalEntity.getDorsalNumber());
	    competitor.setRunnerFullName(dorsalEntity.getRunner().getFullName());
	    competitor.setRunnerId(dorsalEntity.getRunner().getId());
	    resultList.add(competitor);
	}

	return resultList;
    }

}
