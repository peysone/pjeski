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
    private String identificationNumber;
//    nr identyfikacyjny w schronisku - może też być nr chipa
    private String description;
    private String name;
    private Integer estimatedAge;
//    age orientacyjnie
    private String breed;
    private Boolean isPurebred;
    private String dateSinceInShelter;
//    month & year przyjęcia do schroniska
    private Boolean isAvalaibleToAdoption;
    private Boolean isAvailabraForAWalk;
//    todo image
    private AnimalType animalType;

}
