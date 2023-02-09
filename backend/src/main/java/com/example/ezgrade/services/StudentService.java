package com.example.ezgrade.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ezgrade.model.GenericResponse;
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

    public GenericResponse signUp(Student student) {
        return studentRepository.signUp(student);
    }

    public GenericResponse signIn(SignIn signIn) {
        return studentRepository.signIn(signIn);
    }

    public Student getStudent(String studentId) {
        return studentRepository.getStudent(studentId);
    }

}
