package com.example.ezgrade.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ezgrade.model.InstructorClass;
import com.example.ezgrade.model.Student;
import com.example.ezgrade.services.InstructorClassService;
import com.example.ezgrade.services.StudentSessionService;

@RestController
@RequestMapping("api/instructor-classes")
public class StudentInstructorController {

  @Autowired
  InstructorClassService instructorClassService;

  @Autowired
  StudentSessionService studentSessionService;

  @GetMapping("/student")
  public ResponseEntity<List<InstructorClass>> getStudentInstructorClasses(@RequestHeader("student-session") String studentSessionId) {
      try {
          Student student = studentSessionService.getStudent(studentSessionId);
          List<InstructorClass> res = instructorClassService.getStudentClassesByStudentId(student.getStudentId());
          return ResponseEntity.status(HttpStatus.OK).body(res);
      } catch (Exception e) {
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      } 
  }
}
