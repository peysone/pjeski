package com.sda.javagda22.Pjeski.service;

import com.sda.javagda22.Pjeski.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface UserServiceInterface extends UserDetailsService {

    public User findUserByEmail(String email);
    public void saveUser(User user);
    Page<User> findAll(Pageable pageable);
    void updateUserPassword (String newPassword, String email);
    User findUserById (Long id);
    void updateUser (Long id, int roleNr, int active);

    void deleteById(Long id);
}
