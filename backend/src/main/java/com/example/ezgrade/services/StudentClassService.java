package com.example.ezgrade.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ezgrade.model.GenericResponse;
import com.example.ezgrade.model.StudentClass;
import com.example.ezgrade.repo.StudentClassRepository;

@Service
public class StudentClassService {
  @Autowired
  private StudentClassRepository studentClassRepository;

  public GenericResponse addClass(StudentClass studentClass) {
    return studentClassRepository.addClass(studentClass);
  }

  public GenericResponse removeClass(StudentClass studentClass) {
    return studentClassRepository.removeClass(studentClass);
  }

  public List<StudentClass> getStudentClassesByStudentId(String studentId) {
    return studentClassRepository.getStudentClassesByStudentId(studentId);
  }

}