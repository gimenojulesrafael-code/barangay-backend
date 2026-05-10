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
    public String login(@RequestBody User loginUser) {

        if (loginUser.getUsername() == null || loginUser.getPassword() == null) {
            return "Invalid input!";
        }

        User user = userRepository.findByUsername(loginUser.getUsername());

        if (user == null) {
            return "User not found!";
        }

        if (user.getPassword() == null) {
            return "Account has no password set!";
        }

        if (!java.util.Objects.equals(user.getPassword(), loginUser.getPassword())) {
            return "Invalid password!";
        }

        return "Login successful!";
    }
}