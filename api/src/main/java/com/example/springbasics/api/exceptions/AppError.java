package com.example.springbasics.api.exceptions;

public class AppError {

    private int statusCode;
    private String message;

    public AppError(int value, String incorrect_username_or_password) {
        this.statusCode = value;
        this.message = incorrect_username_or_password;
    }
}
