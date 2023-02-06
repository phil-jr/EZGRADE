package com.example.ezgrade.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ezgrade.model.Student;
import com.example.ezgrade.repo.StudentSessionRepository;

@Service
public class StudentSessionService {
    
    @Autowired
    StudentSessionRepository studentSessionRepository;

    public Student getStudent(String studentSessionId) {
        return studentSessionRepository.getStudent(studentSessionId);
    }

}
