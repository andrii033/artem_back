package com.example.artem_back.dto;

import com.example.artem_back.model.Role;

public class AuthenticationResponse {
    public String token;
    public Role role;

    public  AuthenticationResponse(String token, Role role) {
        this.token = token;
        this.role = role;
    }
}
