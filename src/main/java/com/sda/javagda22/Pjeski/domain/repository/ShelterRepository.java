package com.sda.javagda22.Pjeski.domain.repository;


import com.sda.javagda22.Pjeski.domain.model.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShelterRepository extends JpaRepository<Shelter, Long> {

    List<Shelter> findSheltersByCityContaining(String city);
}
