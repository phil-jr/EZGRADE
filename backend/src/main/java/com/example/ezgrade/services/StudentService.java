package com.example.ezgrade.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ezgrade.model.GenericResponse;
import com.example.ezgrade.model.SignIn;
import com.example.ezgrade.model.SignInResponse;
import com.example.ezgrade.model.Student;
import com.example.ezgrade.repo.StudentRepository;
import com.example.ezgrade.validators.ValidateSignUp;

@Service
public class StudentService {

    @Autowired
	StudentRepository studentRepository;

    @Autowired
    private ValidateSignUp validate;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public GenericResponse signUp(Student student) {
        ArrayList<String> errors = validate.validateSignUp(student);
        if(errors.size() > 0) {
            return new GenericResponse("OK", errors);
        } else {
            return studentRepository.signUp(student);
        }  
    }

    public SignInResponse signIn(SignIn signIn) {
        return studentRepository.signIn(signIn);
    }

    public GenericResponse signOut(String sessionId) {
        return studentRepository.signOut(sessionId);
    }

    public Student getStudent(String studentId) {
        return studentRepository.getStudent(studentId);
    }

}
