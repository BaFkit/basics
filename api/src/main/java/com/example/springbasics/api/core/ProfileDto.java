package com.example.springbasics.api.core;

public class ProfileDto {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ProfileDto() {
    }

    public ProfileDto(String username) {
        this.username = username;
    }
}

