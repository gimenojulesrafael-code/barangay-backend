package com.barangay.backend.controller;

import com.barangay.backend.model.Concern;
import com.barangay.backend.repository.ConcernRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/concerns")
@CrossOrigin("*")
public class ConcernController {

    @Autowired
    private ConcernRepository repository;

    @PostMapping("/add")
    public Concern add(@RequestBody Concern concern) {

        System.out.println("=== DEBUG START ===");
        System.out.println("FirstName: " + concern.getFirstName());
        System.out.println("Surname: " + concern.getSurname());
        System.out.println("Address: " + concern.getAddress());
        System.out.println("Type: " + concern.getType());
        System.out.println("Message: " + concern.getMessage());
        System.out.println("=== DEBUG END ===");

        return repository.save(concern);
    }

    @GetMapping
    public List<Concern> getConcerns() {
        return repository.findAll();
    }
}