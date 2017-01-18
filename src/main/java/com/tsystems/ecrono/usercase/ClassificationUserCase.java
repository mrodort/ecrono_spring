package com.tsystems.ecrono.usercase;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsystems.ecrono.domain.DorsalEntity;
import com.tsystems.ecrono.dto.Classification;
import com.tsystems.ecrono.repository.ClassificationRepository;

@Service
public class ClassificationUserCase {

    private final ClassificationRepository classificationRepository;

    @Autowired
    public ClassificationUserCase(ClassificationRepository classificationRepository) {
	super();
	this.classificationRepository = classificationRepository;
    }

    public List<Classification> getClassification(Long raceId) {
	List<DorsalEntity> dorsalsInRace = classificationRepository.getClassificationForRace(raceId);
	List<Classification> classificationList = new LinkedList<>();

	for (DorsalEntity dorsalEntity : dorsalsInRace) {
	    Classification classification = new Classification();
	    classification.setDorsalNumber(dorsalEntity.getDorsalNumber());
	    classification.setRunnerFullName(dorsalEntity.getRunner().getFullName());
	    classification.setRunnerId(dorsalEntity.getRunner().getId());
	    classification.setTime(dorsalEntity.getTimeStamps().iterator().next().getTimeStamp());
	    classificationList.add(classification);
	}

	return classificationList;
    }

}
