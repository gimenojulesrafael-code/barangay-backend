package com.barangay.backend.controller;

import com.barangay.backend.model.User;
import com.barangay.backend.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ================= REGISTER =================
    @PostMapping("/register")
    public String register(@RequestBody User user) {

        User existingUser = userRepository.findByUsername(user.getUsername());

        if (existingUser != null) {
            return "Username already exists!";
        }

        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("USER");
        }

        userRepository.save(user);

        return "User registered successfully!";
    }

    // ================= LOGIN =================
    @PostMapping("/login")
    public String login(@RequestBody User loginUser) {

        User user = userRepository.findByUsername(loginUser.getUsername());

        if (user == null) {
            return "User not found!";
        }

        if (!user.getPassword().equals(loginUser.getPassword())) {
            return "Invalid password!";
        }

        return "Login successful!";
    }
}