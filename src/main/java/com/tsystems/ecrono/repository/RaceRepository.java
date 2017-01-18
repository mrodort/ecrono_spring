package com.tsystems.ecrono.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tsystems.ecrono.domain.RaceEntity;
import com.tsystems.ecrono.domain.component.RaceType;

public interface RaceRepository extends JpaRepository<RaceEntity, Long> {

    List<RaceEntity> findByInitTimeLessThanEqual(Instant filterDate);

    List<RaceEntity> findByTypeEquals(RaceType filterType);

}
