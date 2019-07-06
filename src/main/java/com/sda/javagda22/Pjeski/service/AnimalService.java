package com.sda.javagda22.Pjeski.service;

import com.sda.javagda22.Pjeski.domain.model.animal.Animal;
import com.sda.javagda22.Pjeski.domain.model.Shelter;
import com.sda.javagda22.Pjeski.domain.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AnimalService {

    private final AnimalRepository animalRepository;
    private final ShelterService shelterService;

//    public void createAnimal(Animal animal) {
//        animalRepository.save(animal);
//    }

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Optional<Animal> getAnimalById(Long id) {
        return animalRepository.findById(id);
    }

    public void editAnimal(Animal animal) {
        animalRepository.save(animal);
    }

    public void deleteById(Long id) {
        animalRepository.deleteById(id);
    }

    // Szuca - zmieniona metoda createAnimal pod to, aby był kreowany do sheltera
    public void createAnimal(Animal animal, Long shelterId) {
        Optional<Shelter> shelter = shelterService.getShelterById(shelterId);
        shelter.ifPresent(animal::setShelter);
        animalRepository.save(animal);
    }

    public List<Animal> getAnimalsByShelterCity(String city) {
        return animalRepository.findAnimalByShelter_City(city);
    }


}
