package com.sda.javagda22.Pjeski.controller;

import com.sda.javagda22.Pjeski.domain.model.User;
import com.sda.javagda22.Pjeski.service.UserServiceInterface;
import com.sda.javagda22.Pjeski.utilities.UserUtilities;
import com.sda.javagda22.Pjeski.validators.ChangePasswordValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserServiceInterface userServiceInterface;
    @Autowired
    private ChangePasswordValidator changePasswordValidator;
    @Autowired
    MessageSource messageSource;

    @GetMapping("/profil")
    @Secured(value = {"ROLE_ADMIN", "ROLE_USER", "ROLE_ADMIN_SHELTER"})
    public String showUserProfilePage(Model model) {
        String userName = UserUtilities.getLoggedUser();

        User user = userServiceInterface.findUserByEmail(userName);

        int roleNr = user.getRoles().iterator().next().getId();
        user.setRoleNr(roleNr);
        model.addAttribute("user", user);
        return "user/profil";

    }
    @GetMapping("/edit-password")
    @Secured(value = {"ROLE_ADMIN", "ROLE_USER", "ROLE_ADMIN_SHELTER"})
    public String editPassword(Model model){
        String userName = UserUtilities.getLoggedUser();
        User user = userServiceInterface.findUserByEmail(userName);
        model.addAttribute("user", user);

        return "user/edit-password";
    }

    @PostMapping("/update-pass")
    @Secured(value = {"ROLE_ADMIN", "ROLE_USER", "ROLE_ADMIN_SHELTER"})
    public String updateUserPass(User user, BindingResult result, Model model, Locale locale){

        String returnPage = null;

        changePasswordValidator.checkPasswords(user.getNewPassword(), result);

        changePasswordValidator.validate(user, result);

        if (result.hasErrors()) {
            returnPage = "user/edit-password";
        }else{
            userServiceInterface.updateUserPassword(user.getNewPassword(), user.getEmail());
            returnPage = "user/edit-password";

            model.addAttribute("message", messageSource.getMessage("passwordChange.success", null, locale));
        }

        return returnPage;
    }

    @GetMapping("/admin")
    @Secured(value = {"ROLE_ADMIN"})
    public String showAdminPage(){
        return "user/admin";
    }

    @GetMapping("/users/{page}")
    @Secured(value = {"ROLE_ADMIN"})
    public String openAdminUsersPage(@PathVariable("page") int page, Model model){
        Page<User> pages = getAllUsersPageable(page - 1);
        int totalPages = pages.getTotalPages();
        int currentPage = pages.getNumber();
    List<User> userList = pages.getContent();
    model.addAttribute("totalPages", totalPages);
    model.addAttribute("currentPage", currentPage + 1);
    model.addAttribute("userList", userList);
        return "user/users";
    }

    @GetMapping("/users/edit/{id}")
    @Secured(value = {"ROLE_ADMIN"})
    public String editUserActivAndAdmin (@PathVariable("id") Long id, Model model){
        User user = new User();
        user = userServiceInterface.findUserById(id);
        Map<Integer, String> roleMap = preparingRoleMap();
        Map<Integer, String> activityMap = preparingActivityMap();
        int rola = user.getRoles().iterator().next().getId();
        user.setRoleNr(rola);
        model.addAttribute("roleMap", roleMap);
        model.addAttribute("activityMap", activityMap);
        model.addAttribute("user", user);

        return "user/edituser";
    }


    @PostMapping(value = "/users/edituser/{id}")
    @Secured(value = "ROLE_ADMIN")
    public String updateUser(@PathVariable("id") Long id, User user) {
        int nrRoli = user.getRoleNr();
        int czyActive = user.getActive();
        userServiceInterface.updateUser(id, nrRoli, czyActive);
        return "redirect:/users/1";
    }


//    private List<User> getAllUsers(){
//        List<User> userList = userServiceInterface.findAll();
//        for(User users : userList) {
//
//            int nrRoli = users.getRoles().iterator().next().getId();
//            users.setRoleNr(nrRoli);
//        }
//        return userList;
//    }

    private Page<User> getAllUsersPageable(int page){
        int elements = 3;
        Page<User> pages = userServiceInterface.findAll(PageRequest.of(page, elements));
        for(User users : pages) {

            int nrRoli = users.getRoles().iterator().next().getId();
            users.setRoleNr(nrRoli);
        }
        return pages;
    }
    @Secured(value = "ROLE_ADMIN")
    @GetMapping("users/delete/{id}")
    public String deleteUserById(@PathVariable("id") Long id) {
        userServiceInterface.deleteById(id);
        return "redirect:/users/1";

    }

//    Mapa ról

    public Map<Integer, String> preparingRoleMap(){
        Locale locale = Locale.getDefault();
        Map<Integer, String> roleMap = new HashMap<>();
        roleMap.put(1, messageSource.getMessage("word.admin", null, locale));
        roleMap.put(3, messageSource.getMessage("word.user", null, locale));
        roleMap.put(2, messageSource.getMessage("word.adminShelter", null, locale));
        return roleMap;
    }

    public Map<Integer, String> preparingActivityMap(){
        Locale locale = Locale.getDefault();
        Map<Integer, String> activityMap = new HashMap<>();
        activityMap.put(1, messageSource.getMessage("word.tak", null, locale));
        activityMap.put(0, messageSource.getMessage("word.nie", null, locale));
        return activityMap;
    }

//    Mapa aktiv(ności)


}

