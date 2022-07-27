package com.example.springbasics.auth.services.interfaces;

import com.example.springbasics.auth.entities.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserService {

    User save(User user);

    UserDetails loadUserByUsername(String username);

    Optional<User> findById(Long id);

    Optional<User> findByUsername(String username);

}
