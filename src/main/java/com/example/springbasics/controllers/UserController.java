package com.example.springbasics.controllers;

import com.example.springbasics.converters.UserConverter;
import com.example.springbasics.dto.UserDto;
import com.example.springbasics.entities.User;
import com.example.springbasics.exceptions.ResourceNotFoundException;
import com.example.springbasics.services.interfaces.UserService;
import com.example.springbasics.validators.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserValidator userValidator;
    private final UserConverter userConverter;

    @PostMapping
    public UserDto saveNewUser(@RequestBody UserDto userDto) {
        System.out.println(userDto);
        userValidator.validate(userDto);
        User user = userConverter.dtoToEntity(userDto);
        user = userService.save(user);
        return userConverter.entityToDto(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found, id: " + id));
    }
}
