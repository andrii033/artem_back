package com.example.artem_back.controller;

import com.example.artem_back.dto.AuthenticationResponse;
import com.example.artem_back.dto.RegistrerRequest;
import com.example.artem_back.dto.UserDto;
import com.example.artem_back.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String adminOnly() {
        return "admin";
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers().stream()
                .map(UserDto::new)
                .toList();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegistrerRequest registrerRequest) {
        log.info("RegistrerRequest: {}", registrerRequest);
        return ResponseEntity.ok(userService.registerUser(registrerRequest));
    }
}
