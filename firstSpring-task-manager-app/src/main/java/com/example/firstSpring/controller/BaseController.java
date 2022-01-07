package com.example.firstSpring.controller;

import org.springframework.http.ResponseEntity;

public abstract class BaseController {
    protected ResponseEntity returnBadRequestWithBody (Exception exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
