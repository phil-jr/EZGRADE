package com.example.ezgrade.repo;

import java.util.List;

import com.example.ezgrade.model.InstructorClass;

public interface InstructorClassRepositoryInterface {
  
  public List<InstructorClass> getStudentInstructorClassesByStudentId(String studentId);

}
