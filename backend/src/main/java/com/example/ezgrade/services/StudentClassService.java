package com.example.ezgrade.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ezgrade.model.StudentClass;
import com.example.ezgrade.repo.StudentClassRepository;

@Service
public class StudentClassService {
  @Autowired
  private StudentClassRepository studentClassRepository;

  public ResponseEntity<StudentClass> addClass(StudentClass studentClass) {
    return studentClassRepository.addClass(studentClass);
  }

  public ResponseEntity<StudentClass> removeClass(StudentClass studentClass) {
    return studentClassRepository.removeClass(studentClass);
  }

}