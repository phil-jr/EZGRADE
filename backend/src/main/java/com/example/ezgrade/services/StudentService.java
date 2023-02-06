package com.example.ezgrade.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ezgrade.model.SignIn;
import com.example.ezgrade.model.Student;
import com.example.ezgrade.repo.StudentRepository;

@Service
public class StudentService {

    @Autowired
	StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public ResponseEntity<Student> signUp(Student student) {
        return studentRepository.signUp(student);
    }

    public ResponseEntity<Student> signIn(SignIn signIn) {
        return studentRepository.signIn(signIn);
    }

}
