package com.sda.javagda22.Pjeski.service;

import com.sda.javagda22.Pjeski.domain.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AnimalService {

    private final AnimalRepository animalRepository;
}
