package com.sda.javagda22.Pjeski.domain.model.animal;


import com.sda.javagda22.Pjeski.domain.model.Shelter;
import lombok.Data;

import javax.persistence.*;

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
    /*
   ta waga o której pisałem na slacku
    */
    private Integer weight;
    private Integer estimatedAge; // age orientacyjnie
    private String breed;
    private Boolean isPurebred;
    private String dateSinceInShelter;
//    month & year przyjęcia do schroniska
    private Boolean isAvalaibleToAdoption;
    private Boolean isAvailabraForAWalk;
//    todo image
    private AnimalType animalType;
    private AnimalSex animalSex;

    // Szuca - dodana relacja do sheltera
    @ManyToOne
    private Shelter shelter;

//foty dodajemy w JSP

}
