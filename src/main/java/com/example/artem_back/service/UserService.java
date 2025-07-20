package com.example.artem_back.service;

import com.example.artem_back.dto.AuthenticationRequest;
import com.example.artem_back.dto.AuthenticationResponse;
import com.example.artem_back.dto.RegistrerRequest;
import com.example.artem_back.model.User;
import com.example.artem_back.repository.UserRepository;
import com.example.artem_back.security.AppUserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.jwtService = jwtService;
    }

    public AuthenticationResponse registerUser(RegistrerRequest registrerRequest) {
        User user = new User();
        user.setUsername(registrerRequest.username);
        user.setPassword(passwordEncoder.encode(registrerRequest.password));
        user.setRoles(List.of("USER"));

        userRepository.save(user);

        String token = jwtService.generateToken(new AppUserDetails(user));
        return new AuthenticationResponse(token);
    }

    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {
        User userEntity = userRepository.findByUsername(authenticationRequest.username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        String token = jwtService.generateToken(new AppUserDetails(userEntity));
        return new AuthenticationResponse(token);
    }
}
