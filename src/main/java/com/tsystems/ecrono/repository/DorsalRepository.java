package com.tsystems.ecrono.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tsystems.ecrono.domain.DorsalEntity;
import com.tsystems.ecrono.domain.RunnerEntity;

public interface DorsalRepository extends JpaRepository<DorsalEntity, Long> {

    DorsalEntity findByRaceIdAndRunner(Long raceId, RunnerEntity runner);

    @Query(value = "FROM DorsalEntity d LEFT JOIN FETCH d.runner WHERE d.raceId = ?1")
    List<DorsalEntity> findByRaceId(Long raceId);

    // @Query(value = "DELETE DorsalEntity d LEFT JOIN d.runner r WHERE r.id =?2
    // AND d.raceId = ?1")
    void deleteByRaceIdAndRunner(Long raceId, Long runnerId);

}
