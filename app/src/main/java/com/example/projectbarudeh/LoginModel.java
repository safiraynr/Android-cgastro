package com.example.projectbarudeh;

public class LoginModel {
    public String username;
    public String email;

    public LoginModel() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public LoginModel(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
