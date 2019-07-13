package com.sda.javagda22.Pjeski.service;

import com.sda.javagda22.Pjeski.domain.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserServiceInterface extends UserDetailsService {

    User findUserByEmail(String email);
    void saveUser(User user);

}
