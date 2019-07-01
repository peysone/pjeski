package com.sda.javagda22.Pjeski.controller;

import com.sda.javagda22.Pjeski.domain.model.Animal;
import com.sda.javagda22.Pjeski.domain.repository.AnimalRepository;
import com.sda.javagda22.Pjeski.service.AnimalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/animal")
@Slf4j
public class AnimalController {

    private final AnimalRepository animalRepository;
    private final AnimalService animalService;


    @GetMapping("/create")
    public String createAnimal(Model model){
    model.addAttribute("animal", new Animal());
        return "animal/form";
    }
}
