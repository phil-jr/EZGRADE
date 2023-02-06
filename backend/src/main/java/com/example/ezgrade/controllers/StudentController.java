package com.example.ezgrade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ezgrade.model.SignIn;
import com.example.ezgrade.model.Student;
import com.example.ezgrade.services.StudentService;

@RestController
@RequestMapping("api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/signup")
    public ResponseEntity<Student> signUp(@RequestBody Student student) {
        try {
            return studentService.signUp(student);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }    
    }

    @PostMapping("/signin")
    public ResponseEntity<Student> signIn(@RequestBody SignIn signIn) {
        try {
            return studentService.signIn(signIn);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } 
    }

}
