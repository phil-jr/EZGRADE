package com.example.ezgrade.model;

public class SignIn {
    private String email;
    private String password;

    SignIn(){}

    SignIn(String email, String password){
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
}
