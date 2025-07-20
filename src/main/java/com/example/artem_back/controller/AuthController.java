package com.example.artem_back.controller;

import com.example.artem_back.dto.AuthenticationRequest;
import com.example.artem_back.dto.AuthenticationResponse;
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
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegistrerRequest registrerRequest) {
        return ResponseEntity.ok(userService.registerUser(registrerRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok(userService.login(authenticationRequest));
    }
}
