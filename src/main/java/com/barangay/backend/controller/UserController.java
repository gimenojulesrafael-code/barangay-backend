package com.barangay.backend.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // GET USER BY ID
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // UPDATE USER PROFILE
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        User user = userRepository.findById(id).orElse(null);

        if (user != null) {
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

        return null;
    }
}