package com.example.ezgrade.repo;

import org.springframework.http.ResponseEntity;

import com.example.ezgrade.model.SignIn;
import com.example.ezgrade.model.Student;

public interface StudentRepositoryInterface {

    public ResponseEntity<Student> signUp(Student student);

    public ResponseEntity<Student> signIn(SignIn signIn);

}
