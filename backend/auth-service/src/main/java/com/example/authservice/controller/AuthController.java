package com.example.authservice.controller;

import com.example.authservice.dto.AuthResponse;
import com.example.authservice.dto.LoginRequest;
import com.example.authservice.dto.RegisterRequest;
import com.example.authservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    //register
    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest registerRequest){
        return authService.register(registerRequest);
    }
    //login
    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest loginRequest){
        return authService.login(loginRequest);
    }
}
