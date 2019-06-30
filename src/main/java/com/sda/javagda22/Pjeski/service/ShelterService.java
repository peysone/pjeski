package com.sda.javagda22.Pjeski.service;


import com.sda.javagda22.Pjeski.domain.repository.ShelterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ShelterService {

    private final ShelterRepository shelterRepository;

}
