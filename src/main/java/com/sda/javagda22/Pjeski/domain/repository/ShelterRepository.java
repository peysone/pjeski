package com.sda.javagda22.Pjeski.domain.repository;


import com.sda.javagda22.Pjeski.domain.model.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShelterRepository extends JpaRepository<Shelter, Long> {

    List<Shelter> findSheltersByCityContaining(String city);
    @Query("SELECT distinct s.city from Shelter s")
    List<String> findAllCities();
}
