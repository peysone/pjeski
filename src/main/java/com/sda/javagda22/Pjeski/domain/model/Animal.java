package com.sda.javagda22.Pjeski.domain.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;
    private Integer age;
    private String breed;
    private String dateSinceInShelter;
    private Boolean forAdoption;
    private Boolean isLineage;
    private Boolean isAvailable;
}