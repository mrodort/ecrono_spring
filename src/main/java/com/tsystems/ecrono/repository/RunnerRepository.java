package com.tsystems.ecrono.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tsystems.ecrono.domain.RunnerEntity;

public interface RunnerRepository extends JpaRepository<RunnerEntity, Long> {

}
