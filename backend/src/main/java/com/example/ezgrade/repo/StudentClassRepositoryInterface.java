package com.example.ezgrade.repo;

import org.springframework.http.ResponseEntity;

import com.example.ezgrade.model.StudentClass;

public interface StudentClassRepositoryInterface {
    
    public ResponseEntity<StudentClass> addClass(StudentClass studentClass);

}
