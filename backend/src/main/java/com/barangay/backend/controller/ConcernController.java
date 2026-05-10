package com.barangay.backend.controller;

import com.barangay.backend.model.Concern;
import com.barangay.backend.repository.ConcernRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/concerns")
@CrossOrigin("*")
public class ConcernController {

    private final ConcernRepository repo;

    public ConcernController(ConcernRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Concern addConcern(@RequestBody Concern concern) {
        concern.setStatus("Open"); // default status
        return repo.save(concern);
    }

    @GetMapping
    public List<Concern> getAll() {
        return repo.findAll();
    }
}