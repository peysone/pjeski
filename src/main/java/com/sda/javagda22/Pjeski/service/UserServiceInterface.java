package com.sda.javagda22.Pjeski.service;

import com.sda.javagda22.Pjeski.domain.model.User;

public interface UserServiceInterface {

    public User findUserByEmail(String email);
    public void saveUser(User user);

}
