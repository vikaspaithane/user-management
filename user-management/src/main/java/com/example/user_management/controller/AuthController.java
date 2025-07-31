package com.example.user_management.controller;


import com.example.user_management.dto.JwtResponse;
import com.example.user_management.dto.LoginRequest;
import com.example.user_management.dto.RegisterRequest;

import com.example.user_management.entity.ERole;
import com.example.user_management.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/admin/register")
    public ResponseEntity<String> createByAdmin(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.createUserByAdmin(request, ERole.ROLE_USER));
    }

}
