package com.example.firstSpring.exceptions;

public class UserAlreadyExits extends Exception {
    public UserAlreadyExits(String message) {
        super(message);
    }
}
