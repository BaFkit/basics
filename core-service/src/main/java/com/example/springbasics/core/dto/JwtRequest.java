package com.example.springbasics.core.dto;

import lombok.Data;

@Data
public class JwtRequest {
    private String username;
    private String password;
}
