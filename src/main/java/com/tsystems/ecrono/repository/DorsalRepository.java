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

    void deleteByRaceIdAndRunner(Long raceId, Long runner);

    // Seleccionar por id en HQL
    @Query(value = "FROM DorsalEntity d LEFT JOIN d.runner r WHERE d.raceId = ?1 AND r.id =?2")
    DorsalEntity findByRaceIdAndRunnerId(Long raceId, RunnerEntity runnerId);

    // Borrar por 2 ids en SQL
    @Query(value = "DELETE FROM dorsals WHERE race_id =?1 AND runner_id =?2", nativeQuery = true)
    void deleteByRaceIdAndRunnerId(Long raceId, Long runnerId);

}
