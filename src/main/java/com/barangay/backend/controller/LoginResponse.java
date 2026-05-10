package com.barangay.backend.controller;

import com.barangay.backend.model.User;

public class LoginResponse {
    public boolean success;
    public String message;
    public User user;

    public LoginResponse(boolean success, String message, User user) {
        this.success = success;
        this.message = message;
        this.user = user;
    }
}
