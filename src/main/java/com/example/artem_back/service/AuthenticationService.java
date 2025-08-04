//package com.example.artem_back.service;
//
//import com.example.artem_back.dto.AuthenticationRequest;
//import com.example.artem_back.dto.AuthenticationResponse;
//import com.example.artem_back.dto.RegistrerRequest;
//import com.example.artem_back.model.User;
//import com.example.artem_back.repository.UserRepository;
//import com.example.artem_back.security.AppUserDetails;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class AuthenticationService {
//
//    private final AuthenticationManager authManager;
//    private final JwtService jwtService;
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    public AuthenticationResponse authenticate(AuthenticationRequest request) {
//        authManager.authenticate(
//                new UsernamePasswordAuthenticationToken(request.username, request.password)
//        );
//
//        User user = userRepository.findByUsername(request.username)
//                .orElseThrow();
//
//
//        String token = jwtService.generateToken(new AppUserDetails(user));
//        return new AuthenticationResponse(token);
//    }
//
//}
