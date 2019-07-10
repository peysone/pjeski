package com.sda.javagda22.Pjeski.controller;

import com.sda.javagda22.Pjeski.domain.model.User;
import com.sda.javagda22.Pjeski.service.UserServiceInterface;
import com.sda.javagda22.Pjeski.utilities.UserUtilities;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserServiceInterface userServiceInterface;

    @GetMapping("/profil")
    public String showUserProfilePage(Model model) {
        String userName = UserUtilities.getLoggedUser();

        User user = userServiceInterface.findUserByEmail(userName);

        int roleNr = user.getRoles().iterator().next().getId();
        user.setRoleNr(roleNr);
        model.addAttribute("user", user);
        return "user/profil";

    }
//    1!Dzikirex
}

