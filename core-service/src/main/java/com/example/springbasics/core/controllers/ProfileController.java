package com.example.springbasics.core.controllers;

import com.example.springbasics.core.dto.ProfileDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/profile")
public class ProfileController {
    @GetMapping
    public ProfileDto getCurrentUserInfo(@RequestHeader String username) {
        // User user = userService.findByUsername(username);
        return new ProfileDto(username);
    }
}
