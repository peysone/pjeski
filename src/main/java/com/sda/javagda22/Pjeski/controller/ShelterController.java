package com.sda.javagda22.Pjeski.controller;

import com.sda.javagda22.Pjeski.domain.model.FilterForm;
import com.sda.javagda22.Pjeski.domain.model.Shelter;
import com.sda.javagda22.Pjeski.domain.model.animal.Animal;
import com.sda.javagda22.Pjeski.service.AnimalService;
import com.sda.javagda22.Pjeski.service.ShelterService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/shelter")
@Slf4j
public class ShelterController {
    @Autowired
    private final ShelterService shelterService;

    @Autowired
    private final AnimalService animalService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/create")
    public String createShelter(Model model){
        model.addAttribute("shelter", new Shelter());
        return "shelter/form";
    }

    @PostMapping("/create")
    public String createShelter(@ModelAttribute("shelter") Shelter shelter) {
        shelterService.createShelter(shelter);
        log.info("Created new shelter {}", shelter);
        return "redirect:/shelter/list";
    }

    @GetMapping("/list")
    public String shelterList(Model model) {
        List<Shelter> shelters = shelterService.getAllShelters();
        model.addAttribute("shelters", shelters);
        return "shelter/list";
    }


    //Szuca - tutaj jest szukanie schroniska po mieście i w wyszukiwarce nie trzeba wpisywac całej nazwy,
    // wystarczy kawałek, bo jest Containing w wyszukiwaniu
    @GetMapping("/find-by-city")
    public String findByCityForm(Model model) {
        model.addAttribute("filterForm", new FilterForm());
//        model.addAttribute("cities", shelterService.)
        return "shelter/find";
    }

    @PostMapping("/find-by-city")
    public String findShelterForm(@ModelAttribute("filterForm") FilterForm filterForm,
                                  Model model) {
        List<Shelter> shelters = shelterService.findSheltersByCityContaining(filterForm.getCity());
        model.addAttribute("shelters", shelters);
        return "shelter/list";
    }

    @GetMapping("/animals/{shelterId}")
    public String shelterPage(Model model, @PathVariable("shelterId") Long shelterId) {
        List<Animal> animals = animalService.getAnimalsByShelterId(shelterId);
        Optional<Shelter> maybeShelter = shelterService.getShelterById(shelterId);
        if (!maybeShelter.isPresent()) {
            return "shelter/list";
        } else {
            model.addAttribute("animals", animals);
            model.addAttribute("shelter", maybeShelter.get());
            return "shelter/side";
        }
    }

    @PostMapping("/animals/{shelterId}")
    public String shelterPageF(@ModelAttribute("filterForm") FilterForm filterForm,
                               Model model,
                               @PathVariable("shelterId") Long shelterId) {
        Optional<Shelter> shelters = shelterService.getShelterById(shelterId);
        model.addAttribute("shelters", shelters);
        return "animal/list";
    }
}
