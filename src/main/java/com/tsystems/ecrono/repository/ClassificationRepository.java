package com.tsystems.ecrono.repository;

import java.util.List;

import com.tsystems.ecrono.domain.DorsalEntity;

public interface ClassificationRepository {

    List<DorsalEntity> getClassificationForRace(Long raceId);

}
