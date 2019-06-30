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
//    age orientacyjnie
    private String breed;
    private Boolean lineage;
    private String dateSinceInShelter;
//    month & year przyjęcia do schroniska
    private Boolean isAvalaibleToAdoption;
    private Boolean isAvailabraForAWalk;
//    todo image
//foty dodajemy w JSP
}
