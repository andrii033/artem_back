package com.example.artem_back.service;

import com.example.artem_back.dto.RegistrerRequest;
import com.example.artem_back.model.User;
import com.example.artem_back.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public void registerUser(RegistrerRequest registrerRequest) {
        User user = new User();
        user.setUsername(registrerRequest.username);
        user.setPassword(passwordEncoder.encode(registrerRequest.password));

        user.setRoles(List.of("USER"));

        userRepository.save(user);
    }
}
