package com.example.artem_back.dto;

import com.example.artem_back.model.User;
import lombok.RequiredArgsConstructor;

import java.util.List;

public class UserDto {
    private Long id;
    private String username;
    private List<String> roles;

    public UserDto(Long id, String username, List<String> roles) {
        this.id = id;
        this.username = username;
        this.roles = roles;
    }

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.roles = user.getRoles();
    }
}
