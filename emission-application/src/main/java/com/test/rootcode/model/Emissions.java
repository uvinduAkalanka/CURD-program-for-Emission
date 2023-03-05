package com.test.rootcode.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "emissions")
@Data
public class Emissions {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emissions_generator")
    @SequenceGenerator(name = "emissions_generator", sequenceName = "emissions_id_seq", allocationSize = 1)
    private Integer id;
    @NotNull
    @Column(name = "sector")
    private String sector;
    @NotNull
    @Column(name = "year")
    private Integer year;
    @NotNull
    @Column(name = "statistic")
    private String statistic;

    @Column(name = "statistic_code")
    private String statisticCode;

    @Column(name = "unit")
    private String unit;
    @NotNull
    @Column(name = "value")
    private double value;

}
