package com.sda.javagda22.Pjeski.controller;

import com.sda.javagda22.Pjeski.domain.model.User;
import com.sda.javagda22.Pjeski.service.UserServiceInterface;
import com.sda.javagda22.Pjeski.utilities.PjeskiUtils;
import com.sda.javagda22.Pjeski.validators.UserRegisterValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
@RequiredArgsConstructor

public class RegisterController {

    @Autowired
    private UserServiceInterface userServiceInterface;

    @Autowired
    MessageSource messageSource;

    @GetMapping("/register")
    public String registerForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/adduser")
    public String addUser(User user, BindingResult result, Model model, Locale locale) {
        String returnPage = null;

        User userExist = userServiceInterface.findUserByEmail(user.getEmail());

        new UserRegisterValidator().validateEmailExist(userExist, result);

        new UserRegisterValidator().validate(user, result);

        if (result.hasErrors()) {
            returnPage = "register";
        } else {
            userServiceInterface.saveUser(user);
            model.addAttribute("message", messageSource.getMessage("user.register.success", null, locale));
            model.addAttribute("user", new User());
//        user.setActivationCode(PjeskiUtils.randomStringGenerator());
//
//        String content = "Wymagane potwierdzenie rejestracji. Kliknij w poniższy link aby aktywować konto: " +
//                "http://localhost:8080/activatelink/" + user.getActivationCode();
//
//        userServiceInterface.saveUser(user);
//        emailSender.sendEmail(user.getEmail(), "Potwierdzenie rejestracji", content);
//        model.addAttribute("message", messageSource.getMessage("user.register.success.email", null, locale));
//        //model.addAttribute("user", new User());
            returnPage = "register";
        }

        return returnPage;
    }


}