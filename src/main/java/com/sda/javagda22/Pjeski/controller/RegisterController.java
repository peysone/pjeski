package com.sda.javagda22.Pjeski.controller;

import com.sda.javagda22.Pjeski.domain.model.User;
import com.sda.javagda22.Pjeski.service.EmailSender;
import com.sda.javagda22.Pjeski.service.UserServiceInterface;
import com.sda.javagda22.Pjeski.utilities.PjeskiUtils;
import com.sda.javagda22.Pjeski.validators.UserRegisterValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.Valid;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Locale;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Controller
@RequiredArgsConstructor
public class RegisterController {

    @Autowired
    private UserServiceInterface userServiceInterface;

    @Autowired
    MessageSource messageSource;

    @Autowired
    UserRegisterValidator userRegisterValidator;

    @Autowired
    EmailSender emailSender;





    @GetMapping("/register")
    public String registerForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register/register";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, Locale locale) {

        String returnPage;

        userRegisterValidator.validateEmailExist(user.getEmail(), result);

        userRegisterValidator.validate(user, result);

        if (result.hasErrors()) {
//            model.addAttribute("user", user);
            returnPage = "/register/register";
        } else {
            user.setActivationCode(PjeskiUtils.randomStringGanerator());
            String content = "Aby dokończyć proces rejestracji, kliknij w poniższy link i zaloguj się na swoje konto: " +
                    "<a href='http://localhost:8080/activation/" + user.getActivationCode()+ "'>link</a>. Lub wklej: http://localhost:8080/activation/" + user.getActivationCode();

            userServiceInterface.saveUser(user);
            emailSender.sendEmail(user.getEmail(), "Potwierdzenie rejestracji", content);
            model.addAttribute("message", messageSource.getMessage("user.register.success.email", null, locale));
            model.addAttribute("user", new User());

            returnPage = "/register/register2";
        }

        return returnPage;
    }

    @RequestMapping(value="/activation/{activationCode}")
    public String activateAccount(@PathVariable("activationCode") String activationCode, Model model, Locale locale){

        userServiceInterface.updateUserActivation(1, activationCode);

        model.addAttribute("message", messageSource.getMessage("user.register.success", null, locale));


        return "/register/register2";
    }


}
