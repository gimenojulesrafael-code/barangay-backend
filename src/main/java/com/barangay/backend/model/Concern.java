package com.barangay.backend.model;

import jakarta.persistence.*;

@Entity
public class Concern {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String firstName;
    private String surname;
    private String address;
    private String type;
    private String message;
    private String status;

    // getters & setters
}