package com.example.springbasics.services.interfaces;

import com.example.springbasics.entities.User;

import java.util.Optional;

public interface UserService {

    User save(User user);

    Optional<User> findById(Long id);

    Optional<User> findByUsername(String username);

}
