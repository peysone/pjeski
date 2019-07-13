package com.sda.javagda22.Pjeski.service;

import com.sda.javagda22.Pjeski.domain.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserServiceInterface extends UserDetailsService {

    public User findUserByEmail(String email);
    public void saveUser(User user);

}
