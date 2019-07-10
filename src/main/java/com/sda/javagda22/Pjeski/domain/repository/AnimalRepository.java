package com.sda.javagda22.Pjeski.domain.repository;

import com.sda.javagda22.Pjeski.domain.model.animal.Animal;
import com.sda.javagda22.Pjeski.domain.model.animal.AnimalType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    List<Animal> findAnimalByShelter_City(String city);

//    List<Animal> findAnimalByEstimatedAge(Integer age);

//    List<Animal> findAnimalByWeight(Integer weight);

    List<Animal> findAnimalByAnimalType(AnimalType animalType);


    List<Animal> findAnimalByWeight(Integer weight);

    List<Animal> findAnimalByAnimalType(AnimalType animalType);
}
