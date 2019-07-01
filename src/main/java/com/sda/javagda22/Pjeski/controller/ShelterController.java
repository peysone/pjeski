package com.sda.javagda22.Pjeski.controller;

import com.sda.javagda22.Pjeski.domain.model.Animal;
import com.sda.javagda22.Pjeski.domain.model.Shelter;
import com.sda.javagda22.Pjeski.service.ShelterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/shelter")
@Slf4j
public class ShelterController {

    private final ShelterService shelterService;

    @GetMapping("/create")
    public String createAnimal(Model model){
        model.addAttribute("shelter", new Shelter());
        return "shelter/form";
    }

}
