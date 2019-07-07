package com.sda.javagda22.Pjeski.service;

import com.sda.javagda22.Pjeski.domain.model.User;

public interface UserServiceInterface {

    User findUserByEmail(String email);
    void saveUser(User user);

}
