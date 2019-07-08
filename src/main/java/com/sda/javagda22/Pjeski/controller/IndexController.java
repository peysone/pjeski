package com.sda.javagda22.Pjeski.controller;

import com.sda.javagda22.Pjeski.domain.model.FilterForm;
import com.sda.javagda22.Pjeski.domain.model.animal.Animal;
import com.sda.javagda22.Pjeski.service.AnimalService;
import com.sda.javagda22.Pjeski.service.ShelterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class IndexController {

    @Autowired
    private final AnimalService animalService;
    private final ShelterService shelterService;

    @GetMapping("/")
    public String findAnimalByCity(Model model) {
        List<String> allCities = shelterService.getAllCities();
        model.addAttribute("allCities", allCities);
        model.addAttribute("filterForm", new FilterForm());
        return "index";
    }

    @PostMapping("/index")
    public String findAnimalForm(@ModelAttribute("filterForm") FilterForm filterForm,
                                 Model model) {
        List<Animal> animals = animalService.getAnimalsByShelterCity(filterForm.getCity());
        model.addAttribute("animals", animals);
        return "animal/list";
    }

    @GetMapping("/about")
    public String goToAbout() {
        return "about";
    }
}
