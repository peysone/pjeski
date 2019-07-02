package com.sda.javagda22.Pjeski.controller;

import com.sda.javagda22.Pjeski.domain.model.Animal;
import com.sda.javagda22.Pjeski.domain.repository.AnimalRepository;
import com.sda.javagda22.Pjeski.service.AnimalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/animal")
@Slf4j
public class AnimalController {

    private final AnimalService animalService;

    @GetMapping("/create")
    public String createAnimal(Model model) {
        model.addAttribute("animal", new Animal());
        return "animal/form";
    }

    @PostMapping("/create")
    public String createAnimal(@ModelAttribute("animal") Animal animal) {
        animalService.createAnimal(animal);
        log.info("Created new animal {}", animal);
        return "redirect:/animal/list";
    }

    @GetMapping("/edit/{id}")
    public String editAnimalForm(@PathVariable("id") Long id, Model model) {
        Optional<Animal> maybeAnimal = animalService.getAnimalById(id);

        if (!maybeAnimal.isPresent()) {
            return "redirect:/animal/create";
        } else {
            model.addAttribute("animal", maybeAnimal.get());
            return "animal/edit-form";
        }
    }

    @PostMapping("/edit/{id}")
    public String editAnimal(@ModelAttribute("animal") Animal animal) {
        animalService.editAnimal(animal);
        return "redirect:/animal/list";
    }

    @GetMapping("/list")
    public String animalList(Model model) {
        List<Animal> animals = animalService.getAllAnimals();
        model.addAttribute("animals", animals);
        return "animal/list";
    }

}
