package com.barangay.backend.controller;

import com.barangay.backend.model.User;
import com.barangay.backend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updated) {

        User user = userRepository.findById(id).orElse(null);

        if (user == null) return null;

        user.setFirstName(updated.getFirstName());
        user.setMiddleName(updated.getMiddleName());
        user.setSurname(updated.getSurname());
        user.setEmail(updated.getEmail());
        user.setAddress(updated.getAddress());
        user.setZone(updated.getZone());
        user.setAge(updated.getAge());
        user.setGender(updated.getGender());
        user.setOccupation(updated.getOccupation());

        return userRepository.save(user);
    }
}