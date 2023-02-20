package com.example.ezgrade.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ezgrade.model.InstructorClass;
import com.example.ezgrade.repo.InstructorClassRepository;

@Service
public class InstructorClassService {

  @Autowired
  private InstructorClassRepository instructorClassRepository;
  
  public List<InstructorClass> getStudentClassesByStudentId(String studentId) {
    return instructorClassRepository.getStudentInstructorClassesByStudentId(studentId);
  }

}
