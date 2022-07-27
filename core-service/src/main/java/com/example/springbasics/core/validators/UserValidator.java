package com.example.springbasics.core.validators;

import com.example.springbasics.core.dto.UserDto;
import com.example.springbasics.core.exceptions.ValidationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserValidator {
    public void validate(UserDto userDto) {
        List<String> errors = new ArrayList<>();
        if (userDto.getUsername().isBlank()) {
            errors.add("User name cannot be blank");
        }
        if (userDto.getEmail().isBlank()) {
            errors.add("Email cannot be blank");
        }
        if (userDto.getPassword().isBlank()) {
            errors.add("Password cannot be blank");
        }
        if (!errors.isEmpty()) {
            throw  new ValidationException(errors);
        }
    }
}
