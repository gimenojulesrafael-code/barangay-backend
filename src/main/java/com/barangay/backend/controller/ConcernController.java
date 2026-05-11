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
    private ConcernRepository concernRepository;

    // GET ALL
    @GetMapping("/all")
    public List<Concern> getAllConcerns() {
        return concernRepository.findAll();
    }

    // POST ADD
    @PostMapping("/add")
    public Concern addConcern(@RequestBody Concern concern) {
        return concernRepository.save(concern);
    }
}