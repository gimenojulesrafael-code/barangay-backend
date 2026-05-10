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
    public User getUser(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {

        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return null;
        }

        user.setFirstName(updatedUser.getFirstName());
        user.setMiddleName(updatedUser.getMiddleName());
        user.setSurname(updatedUser.getSurname());
        user.setEmail(updatedUser.getEmail());
        user.setAddress(updatedUser.getAddress());
        user.setZone(updatedUser.getZone());
        user.setAge(updatedUser.getAge());
        user.setGender(updatedUser.getGender());
        user.setOccupation(updatedUser.getOccupation());

        return userRepository.save(user);
    }
}