package com.sda.javagda22.Pjeski.controller;

import com.sda.javagda22.Pjeski.domain.model.FilterForm;
import com.sda.javagda22.Pjeski.domain.model.animal.Animal;
import com.sda.javagda22.Pjeski.service.AnimalService;
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
@RequestMapping("/animal")
@Slf4j
public class AnimalController {

    @Autowired
    private final AnimalService animalService;

    // Szuca - od teraz animala dodajemy od razu do schroniska, ponieważ bez sensu jest dodawać go bez przypisania do schroniska
    //więc posłużyłam sie kodem z kliniki i stworzyłam coś takiego i tu tylko create jest zmienione
    @GetMapping("/create/{shelterId}")
    public String createAnimal(Model model, @PathVariable("shelterId") Long shelterId ) {
        model.addAttribute("animal", new Animal());
        model.addAttribute("shelterId", shelterId);
        return "animal/form";
    }

    @PostMapping("/create/{shelterId}")
    public String createAnimal(@ModelAttribute("animal") Animal animal, @PathVariable("shelterId") Long shelterId) {
        animalService.createAnimal(animal, shelterId);

        return "redirect:/shelter/list";
    }

//    @PostMapping("/create")
//    public String createAnimal(@ModelAttribute("animal") Animal animal) {
//        animalService.createAnimal(animal);
//        log.info("Created new animal {}", animal);
//        return "redirect:/animal/list";
//    }

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


    @GetMapping("/delete/{id}")
    public String deleteAnimalById(@PathVariable("id")Long id){
        animalService.deleteById(id);
        return "redirect:/animal/list";
    }

    @GetMapping("/find-by-city")
    public String findByLastNameForm(Model model) {
        model.addAttribute("filterForm", new FilterForm());
        return "animal/find";
    }

    @PostMapping("/find-by-city")
    public String findAnimalForm(@ModelAttribute("filterForm") FilterForm filterForm,
                                 Model model) {
        List<Animal> animals = animalService.getAnimalsByShelterCity(filterForm.getCity());
        model.addAttribute("animals", animals);
        return "animal/list";
    }

//    @GetMapping("/filter-by-age")
//    public String filterByAgeForm(Model model) {
//        model.addAttribute("filterForm", new FilterForm());
//        return "animal/coś";
//        /*
//        trzeba dodać jsp = wiem że nie powinno tu byc coś,
//        tylko kolejny jsp, ale już nie mam sił na to, na dole to samo
//        Rudini
//         */
//    }
//
//    @PostMapping("/filter-by-age")
//    public String filterAnimalByAge(@ModelAttribute("filterForm") FilterForm filterForm,
//                                    Model model) {
//        List<Animal> animals = animalService.getAnimalByEstimatedAge(filterForm.getEstimatedAge());
//        model.addAttribute("animals", animals);
//        return "animal/list";
//    }
//
//    @GetMapping("/filter-by-weight")
//    public String filterAnimalByWeightForm(Model model) {
//        model.addAttribute("filterForm", new FilterForm());
//        return "animal/coś";
//    }
//
//    @PostMapping("/filter-by-weight")
//    public String filterAnimalByWeight(@ModelAttribute("filterForm") FilterForm filterForm,
//                                       Model model) {
//        List<Animal> animals = animalService.getAnimalByWeight(filterForm.getWeight());
//        model.addAttribute("animals", animals);
//        return "animal/list";
//    }

    @GetMapping("/filter-by-type")
    public String filterAnimalsByType(Model model) {
        model.addAttribute("filterForm", new FilterForm());
        return "animal/coś";
    }

    @PostMapping("/filter-by-type")
    public String filterAnimalByType(@ModelAttribute("filterForm") FilterForm filterForm,
                                     Model model) {
        List<Animal> animals = animalService.getAnimalByAnimalType(filterForm.getAnimalType());
        model.addAttribute("animals", animals);
        return "animal/list";
    }
}
