package com.sda.javagda22.Pjeski.service;

import com.sda.javagda22.Pjeski.domain.model.Animal;
import com.sda.javagda22.Pjeski.domain.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    public void createAnimal(Animal animal) {
        animalRepository.save(animal);
    }

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
}
