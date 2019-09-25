package com.sda.javagda22.Pjeski.service;

import com.sda.javagda22.Pjeski.domain.model.Role;
import com.sda.javagda22.Pjeski.domain.model.User;
import com.sda.javagda22.Pjeski.domain.repository.RoleRepository;
import com.sda.javagda22.Pjeski.domain.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
@Data
@Service
@Transactional
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(0);
        Role role = roleRepository.findByRole("ROLE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(role)));

        userRepository.save(user);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
    return userRepository.findAll(pageable);

    }

    @Override
    public void updateUserPassword(String newPassword, String email) {
        userRepository.updateUserPassword(bCryptPasswordEncoder.encode(newPassword), email);
    }

    @Override
    public User findUserById(Long id) {
        User user = userRepository.findUserById(id);
        return user;
    }

    @Override
    public void updateUser(Long id, int roleNr, int active) {
        userRepository.updateUserActivity(active, id);
        userRepository.updateUserRole(roleNr, id);
    }

    @Override
    public void deleteById(Long id) {

        userRepository.deleteUserFromUserRole(id);
        userRepository.deleteUserFromUser(id);
    }

    @Override
    public void updateUserActivation(int activeCode, String activationCode) {
        userRepository.updateActivation(activeCode, activationCode);
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByEmail(s);
    }

    public Long getLoggedUserId() {
        return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
    }
}

