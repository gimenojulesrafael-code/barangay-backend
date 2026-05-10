package com.barangay.backend.controller;

import com.barangay.backend.model.LoginResponse;
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

        if (user.getUsername() == null || user.getPassword() == null) {
            return "Missing required fields!";
        }

        if (userRepository.findByUsername(user.getUsername()) != null) {
            return "Username already exists!";
        }

        if (user.getRole() == null) {
            user.setRole("USER");
        }

        userRepository.save(user);

        return "User registered successfully!";
    }

    // ================= LOGIN =================
    @PostMapping("/login")
    public LoginResponse login(@RequestBody User loginUser) {

        if (loginUser.getUsername() == null || loginUser.getPassword() == null) {
            return new LoginResponse(false, "Invalid input", null);
        }

        User user = userRepository.findByUsername(loginUser.getUsername());

        if (user == null) {
            return new LoginResponse(false, "User not found", null);
        }

        if (user.getPassword() == null ||
                !user.getPassword().equals(loginUser.getPassword())) {
            return new LoginResponse(false, "Invalid password", null);
        }

        return new LoginResponse(true, "Login successful", user);
    }
}