package com.sda.javagda22.Pjeski.service;


import com.sda.javagda22.Pjeski.domain.model.Shelter;
import com.sda.javagda22.Pjeski.domain.repository.ShelterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ShelterService {

    private final ShelterRepository shelterRepository;

    public void createShelter(Shelter shelter) {
        shelterRepository.save(shelter);
    }

    public List<Shelter> getAllShelters() {
        System.out.println(shelterRepository.findAllCities());
        return shelterRepository.findAll();
    }

    // Szuca - do wyszukania miasta nie po całej nazwie
    public List<Shelter> findSheltersByCityContaining(String city) {
        return shelterRepository.findSheltersByCityContaining(city);
    }

    public Optional<Shelter> getShelterById(Long id) {
        return shelterRepository.findById(id);
    }

}
