package com.sda.javagda22.Pjeski.controller;

import com.sda.javagda22.Pjeski.domain.model.FilterForm;
import com.sda.javagda22.Pjeski.domain.model.User;
import com.sda.javagda22.Pjeski.domain.model.Visit;
import com.sda.javagda22.Pjeski.domain.model.animal.Animal;
import com.sda.javagda22.Pjeski.domain.model.animal.PhotoDAO;
import com.sda.javagda22.Pjeski.domain.model.animal.PhotoDTO;
import com.sda.javagda22.Pjeski.service.AnimalService;
import com.sda.javagda22.Pjeski.service.ShelterService;
import com.sda.javagda22.Pjeski.service.UserService;
import com.sda.javagda22.Pjeski.service.VisitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.util.StreamUtils.BUFFER_SIZE;

@Controller
@RequiredArgsConstructor
@RequestMapping("/animal")
@Slf4j
public class AnimalController {

    private final AnimalService animalService;
    private final ShelterService shelterService;
    private final VisitService visitService;
    private final UserService userService;
    private final PhotoDAO photoDAO;

    // Szuca - od teraz animala dodajemy od razu do schroniska, ponieważ bez sensu jest dodawać go bez przypisania do schroniska
    //więc posłużyłam sie kodem z kliniki i stworzyłam coś takiego i tu tylko cerate jest zmienione
    @GetMapping("/create/{shelterId}")
    @Secured(value = {"ROLE_ADMIN"})
    public String createAnimal(Model model, @PathVariable("shelterId") Long shelterId) {
        model.addAttribute("animal", new Animal());
        model.addAttribute("shelterId", shelterId);
        return "animal/form";
    }

    @PostMapping("/create/{shelterId}")
    @Secured(value = {"ROLE_ADMIN"})
    public ModelAndView createAnimal(@ModelAttribute("animal") Animal animal, @PathVariable("shelterId") Long shelterId, @RequestParam("files") MultipartFile files) {
        animalService.createAnimal(animal, shelterId);
        ModelAndView modelAndView = new ModelAndView();

        PhotoDTO photoDTO = new PhotoDTO();
        photoDTO.setFileName(files.getOriginalFilename());
        photoDTO.setPath("/resources/static/photos/");
        photoDTO.setAnimal(animal);
        modelAndView.setViewName("animal/success");

        try {
            animalService.saveImage(files, photoDTO);

        } catch (Exception e) {
            e.printStackTrace();
            modelAndView.setViewName("error");
            return modelAndView;
        }

//        return "redirect:/animal/list/1";

        modelAndView.addObject("photoDTO", photoDTO);
        modelAndView.addObject("animal", animal);

        return modelAndView;
    }

//    @PostMapping("/create")
//    public String createAnimal(@ModelAttribute("animal") Animal animal) {
//        animalService.createAnimal(animal);
//        log.info("Created new animal {}", animal);
//        return "redirect:/animal/list";
//    }
    @Secured(value = {"ROLE_ADMIN", "ROLE_SHELTER_ADMIN"})
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
    @Secured(value = {"ROLE_ADMIN", "ROLE_SHELTER_ADMIN"})
    @PostMapping("/edit/{id}")
    public String editAnimal(@ModelAttribute("animal") Animal animal) {
        animalService.editAnimal(animal);
        return "redirect:/animal/list/1";
    }

    @GetMapping("/list/{page}")
    public String openAnimalListPageable(@PathVariable("page") int page, Model model, Animal animal){
        Page<Animal> animalPages = getAllAnimalsPageable(page - 1);
        int totalPages = animalPages.getTotalPages();
        int currentPage = animalPages.getNumber();
        List<Animal> animalList = animalPages.getContent();
        String firstPhoto = photoDAO.getFirstPhoto();
//        zamysł był taki żeby ten string to była nazwa pierwszego zdjęcia animala do wyświetlenia na liście.
//        Wyszło że pobiera pierwsze zdjęcie z tabeli PhotoDTO niezależnie od animala
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage + 1);
        model.addAttribute("animals", animalList);
        model.addAttribute("firstPhoto", firstPhoto);
        return "animal/list";
    }

    private Page<Animal> getAllAnimalsPageable(int page){
        int elements = 3;
        return animalService.findAll(PageRequest.of(page, elements));

    }

    @GetMapping("/list")
    public String animalList(Model model) {
        List<Animal> animals = animalService.getAllAnimals();
        model.addAttribute("animals", animals);
        return "animal/list";
    }

//    @GetMapping("/upload")
//    public String uploadFile(){
//        return "/animal/upload";
//    }

//    @RequestMapping(value="/upload", method=RequestMethod.POST)
//    public String handleFileUpload(@RequestParam("plik") MultipartFile file){
//        if (!file.isEmpty()) {
//            try { UUID uuid = UUID.randomUUID();
//                String filename = "/uploads/upload_"+uuid.toString();
//                byte[] bytes = file.getBytes();
//                File fsFile = new File(filename);
//                fsFile.createNewFile();
//                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(fsFile));
//                stream.write(bytes);
//                stream.close();
////                logger.info("File {} has been successfully uploaded as {}", new Object[] {file.getOriginalFilename(), filename});
//            } catch (Exception e) {
////                logger.error("File has not been uploaded", e);
//            }
//        } else {
////            logger.error("Uploaded file is empty");
//        } return "/animal/upload";
//    }

//    @RequestMapping(method = RequestMethod.GET)
//    public void pobierz(@PathVariable("attchamentId") Long attachmentId, HttpServletResponse response)
//            throws IOException {
//        Attachement attachement = ...; //pobierz na podstawie id
//        FileInputStream inputStream = new FileInputStream(attachment.getFileLocation());
//        response.setContentType(attachment.getMimeType());
//        response.setContentLength(attachment.getSize());
//        String headerValue = String.format("attachment; filename=\"%s\"", attachment.getOriginalFilename());
//        response.setHeader("Content-Disposition", headerValue);
//        OutputStream outStream = response.getOutputStream();
//        byte[] buffer = new byte[BUFFER_SIZE];
//        int bytesRead = -1; // czytamy w pętli po fragmencie, który następnie przepisujemy do strumienia wyjściowego
//        while ((bytesRead = inputStream.read(buffer)) != -1) {
//            outStream.write(buffer, 0, bytesRead);
//        }
//        inputStream.close();
//        outStream.close();
//    }


    @Secured(value = {"ROLE_ADMIN", "ROLE_SHELTER_ADMIN"})
    @GetMapping("/delete/{id}")
    public String deleteAnimalById(@PathVariable("id") Long id) {
        animalService.deleteById(id);
        return "redirect:/animal/list/1";
    }

    @GetMapping("/find-by-city")
    public String findByLastNameForm(Model model) {
        List<String> allCities = shelterService.getAllCities();
        model.addAttribute("allCities", allCities);
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


    @GetMapping("/filter-by-type")
    public String filterAnimalsByType(Model model) {
        model.addAttribute("filterForm", new FilterForm());
        return "animal/filter";
    }

    @PostMapping("/filter-by-type")
    public String filterAnimalByType(@ModelAttribute("filterForm") FilterForm filterForm,
                                     Model model) {
        List<Animal> animals = animalService.getAnimalByAnimalType(filterForm.getAnimalType());
        model.addAttribute("animals", animals);
        return "animal/list";
    }

    @GetMapping("/visit/{animalId}")
    public String createVisit(Model model, @PathVariable("animalId") Long animalId) {
        Long userId = userService.getLoggedUserId();
        model.addAttribute("visit", new Visit());
        model.addAttribute("animalId", animalId);
        model.addAttribute("userId", userId);
        return "animal/visit";
    }

    @PostMapping("/visit/{animalId}")
    public String createVisit(@ModelAttribute("visit") Visit visit,
                              @PathVariable("animalId") Long animalId
    ) {
        Long userId = userService.getLoggedUserId();
        visitService.createVisit(visit, animalId, userId);

        return "redirect:/animal/list-visit";
    }

    @GetMapping("/list-visit")
    public String visitList(Model model) {
        List<Visit> visits = visitService.getAllVisits();
        model.addAttribute("visits", visits);
        return "animal/list-visit";
    }
}
