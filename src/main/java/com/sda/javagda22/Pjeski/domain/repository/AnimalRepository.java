package com.sda.javagda22.Pjeski.domain.repository;

import com.sda.javagda22.Pjeski.domain.model.animal.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
