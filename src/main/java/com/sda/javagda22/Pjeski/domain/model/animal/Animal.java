package com.sda.javagda22.Pjeski.domain.model.animal;

import com.sda.javagda22.Pjeski.domain.model.Shelter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long Id;
    private String identificationNumber; //    nr identyfikacyjny w schronisku - może też być nr chipa
    private String description;
//    private String pic;  poniżej lista zdjęć @Adrian
    private String name;
    private Integer estimatedAge; //    age orientacyjnie
    private String breed;
    private String dateSinceInShelter; // month & year przyjęcia do schroniska
    private Boolean isPurebred;
    private Boolean isAvailableToAdoption;
    private Boolean isAvailableForAWalk;
    private AnimalType animalType;
    private AnimalSex animalSex;
    private AnimalWeight weight;
    @ManyToOne
    private Shelter shelter;
    @OneToMany(mappedBy = "animal", fetch = FetchType.LAZY)
    private List<PhotoDTO> photos;

}



