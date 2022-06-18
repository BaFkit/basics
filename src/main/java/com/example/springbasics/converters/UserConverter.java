package com.example.springbasics.converters;

import com.example.springbasics.dto.UserDto;
import com.example.springbasics.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User dtoToEntity(UserDto userDto) {
        return new User(userDto.getUsername(), userDto.getPassword(), userDto.getEmail());
    }

    public UserDto entityToDto(User user) {
        return new UserDto(user.getUsername(), user.getPassword(), user.getEmail());
    }

}
