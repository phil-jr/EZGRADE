package com.example.ezgrade.model;

import java.util.List;

public class GenericResponse {
    private String status;
    private List<String> errors;

    GenericResponse () {}

    public GenericResponse(String status, List<String> errors) {
        this.status = status;
        this.errors = errors;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public List<String> getErrors() {
        return errors;
    }
    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    
    
}
