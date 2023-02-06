package com.example.ezgrade.repo;

import com.example.ezgrade.model.Student;

public interface StudentSessionRepositoryInterface {
    public Student getStudent(String studentSessionId);
}
