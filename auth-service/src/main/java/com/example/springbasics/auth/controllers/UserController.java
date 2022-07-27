package com.example.springbasics.auth.controllers;

import com.example.springbasics.auth.converters.UserConverter;
import com.example.springbasics.auth.dto.UserDto;
import com.example.springbasics.auth.entities.User;
import com.example.springbasics.auth.exceptions.ResourceNotFoundException;
import com.example.springbasics.auth.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserConverter userConverter;

    @PostMapping
    public UserDto saveNewUser(@RequestBody UserDto userDto) {
        System.out.println(userDto);
        User user = userConverter.dtoToEntity(userDto);
        user = userService.save(user);
        return userConverter.entityToDto(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found, id: " + id));
    }
}
