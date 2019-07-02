package com.sda.javagda22.Pjeski.controller;

import com.sda.javagda22.Pjeski.domain.model.Animal;
import com.sda.javagda22.Pjeski.domain.model.Shelter;
import com.sda.javagda22.Pjeski.service.ShelterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/shelter")
@Slf4j
public class ShelterController {

    private final ShelterService shelterService;

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

}
