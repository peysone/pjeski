package com.sda.javagda22.Pjeski.service;

import com.sda.javagda22.Pjeski.domain.model.User;
import com.sda.javagda22.Pjeski.domain.model.Visit;
import com.sda.javagda22.Pjeski.domain.model.animal.Animal;
import com.sda.javagda22.Pjeski.domain.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class VisitService {

    private final VisitRepository visitRepository;
    private final AnimalService animalService;
    private final UserService userService;

    public void createVisit(Visit visit, Long animalId, Long userId) {
        Optional<Animal> animal = animalService.getAnimalById(animalId);
        animal.ifPresent(visit::setAnimal);

        Optional<User> user = userService.getUserById(userId);
        user.ifPresent(visit::setUser);

        visitRepository.save(visit);
    }

    public List<Visit> getAllVisits() {
        return visitRepository.findAll();
    }
}
