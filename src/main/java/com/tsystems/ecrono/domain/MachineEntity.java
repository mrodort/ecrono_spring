package com.tsystems.ecrono.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "machines")
@Data
@ToString(of = { "id", "machine" })
@EqualsAndHashCode(of = "id")
public class MachineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "machine_code", unique = true)
    private String machine;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "machineId")
    private List<TimeStampEntity> timeStamp;

}
