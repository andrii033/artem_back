package com.example.artem_back.controller;

import com.example.artem_back.dto.RegistrerRequest;
import com.example.artem_back.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegistrerRequest registrerRequest) {
        userService.registerUser(registrerRequest);
        return ResponseEntity.ok("User registered successfully");
    }
}
