package com.tsystems.ecrono.domain;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.tsystems.ecrono.domain.component.RaceType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "races")
@Data
@ToString(of = { "id", "name" })
@EqualsAndHashCode(of = "id")
public class RaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "distance_in_meters")
    private Double distanceInMeters;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private RaceType type;

    @Column(name = "init_time")
    private Instant initTime;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "dorsals", joinColumns = @JoinColumn(name = "race_id"), inverseJoinColumns = @JoinColumn(name = "runner_id"))
    private List<RunnerEntity> runners;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "raceId")
    private List<DorsalEntity> dorsals;
}
