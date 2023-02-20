package com.example.ezgrade.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.ezgrade.mapper.InstructorClassMapper;
import com.example.ezgrade.model.InstructorClass;

import static com.example.ezgrade.constants.InstructorClassesSql.SELECT_STUDENT_INSTITUTION_CLASSES;

@Repository
public class InstructorClassRepository {

  @Autowired
  JdbcTemplate jdbcTemplate;
  
  public List<InstructorClass> getStudentInstructorClassesByStudentId(String studentId) {

    List<InstructorClass> studentInstructorClasses;
    try {

      studentInstructorClasses = jdbcTemplate.query(SELECT_STUDENT_INSTITUTION_CLASSES, new InstructorClassMapper(), new Object[]{studentId});
      return studentInstructorClasses;
    
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }

  }

}
