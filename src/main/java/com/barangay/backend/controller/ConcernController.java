package com.barangay.backend.controller;

import com.barangay.backend.model.Concern;
import com.barangay.backend.repository.ConcernRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/concerns")
@CrossOrigin(origins = "*")
public class ConcernController {

    @Autowired
    private ConcernRepository repo;

    // GET ALL
    @GetMapping("/all")
    public List<Concern> getAll() {
        return repo.findAll();
    }

    // ADD CONCERN
    @PostMapping("/add")
    public Concern add(@RequestBody Concern concern) {
        return repo.save(concern);
    }
}