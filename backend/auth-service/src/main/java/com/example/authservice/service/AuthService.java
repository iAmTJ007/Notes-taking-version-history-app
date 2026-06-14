package com.example.authservice.service;

import com.example.authservice.dto.AuthResponse;
import com.example.authservice.dto.LoginRequest;
import com.example.authservice.dto.RegisterRequest;
import com.example.authservice.entity.User;
import com.example.authservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private JwtService jwtService;

    public String register(RegisterRequest registerRequest) {
        User user=User.builder()
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .build();

        userRepository.save(user);
        return "user saved successfully";
    }

    public AuthResponse login(LoginRequest loginRequest) {
        User user=userRepository.findUserByUsername(loginRequest.getUsername()).orElseThrow();
        if(!passwordEncoder.matches(loginRequest.getPassword(),user.getPassword())){
            throw new RuntimeException("password incorrect");
        }
        return jwtService.generateToken(loginRequest.getUsername());
    }
}
