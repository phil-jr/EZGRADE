package com.example.ezgrade.repo;

import com.example.ezgrade.model.GenericResponse;
import com.example.ezgrade.model.SignIn;
import com.example.ezgrade.model.Student;

public interface StudentRepositoryInterface {

    public GenericResponse signUp(Student student);

    public GenericResponse signIn(SignIn signIn);

    public Student getStudent(String studentId);

}
