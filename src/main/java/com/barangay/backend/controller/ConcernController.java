package com.barangay.backend.controller;

import com.barangay.backend.model.Concern;
import com.barangay.backend.repository.ConcernRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/concerns")
@CrossOrigin("*")
public class ConcernController {

    @Autowired
    private ConcernRepository repository;

    // CREATE concern
    @PostMapping("/add")
    public Concern add(@RequestBody Concern concern) {
        return repository.save(concern);
    }

    // GET all concerns (ADMIN / DEBUG)
    @GetMapping
    public List<Concern> getAll() {
        return repository.findAll();
    }

    // GET by user
    @GetMapping("/user/{userId}")
    public List<Concern> getByUser(@PathVariable Long userId) {
        return repository.findByUserId(userId);
    }
}