package com.sda.javagda22.Pjeski.controller;

import com.sda.javagda22.Pjeski.domain.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/animal")
@Slf4j
public class AnimalController {

    private final AnimalRepository animalRepository;

    @GetMapping("/create")
    public String createAnimal(){

        return "animal/form";
    }
}
