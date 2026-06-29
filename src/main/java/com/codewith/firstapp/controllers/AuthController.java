package com.codewith.firstapp.controllers;

import com.codewith.firstapp.models.User;
import com.codewith.firstapp.security.JwtUtil;

import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User user) {

        if ("admin".equals(user.getUsername()) &&
            "1234".equals(user.getPassword())) {

            String token = JwtUtil.generateToken(user.getUsername());
            return Map.of("token", token);
        }

        throw new RuntimeException("Invalid credentials");
    }
}