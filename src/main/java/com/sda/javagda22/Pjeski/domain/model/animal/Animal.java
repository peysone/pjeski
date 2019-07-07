package com.sda.javagda22.Pjeski.domain.model.animal;


import com.sda.javagda22.Pjeski.domain.model.Shelter;
import com.sda.javagda22.Pjeski.domain.model.animal.AnimalType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String identificationNumber; // nr identyfikacyjny w schronisku - może też być nr chipa
    private String description;
    private String name;
    private Integer estimatedAge; // age orientacyjnie
    private String breed;
    private String dateSinceInShelter; // month & year przyjęcia do schroniska

    private Boolean isPurebred;
    private Boolean isAvalaibleToAdoption;
    private Boolean isAvailabraForAWalk;
    private AnimalType animalType;
    private AnimalSex animalSex;

    private Integer weight; //dodane przeze mnie



    @ManyToOne
    private Shelter shelter;

//foty dodajemy w JSP

}
