package com.tsystems.ecrono.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tsystems.ecrono.domain.DorsalEntity;
import com.tsystems.ecrono.domain.RunnerEntity;

public interface DorsalRepository extends JpaRepository<DorsalEntity, Long> {

    DorsalEntity findByRaceIdAndRunner(Long raceId, RunnerEntity runner);

    void deleteByRaceIdAndRunner(Long raceId, RunnerEntity runner);

}
