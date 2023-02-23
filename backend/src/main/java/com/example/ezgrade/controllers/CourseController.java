package com.example.ezgrade.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ezgrade.model.Course;
import com.example.ezgrade.model.Student;
import com.example.ezgrade.model.CourseResponse.CourseCard;
import com.example.ezgrade.services.CourseService;
import com.example.ezgrade.services.StudentSessionService;

@RestController
@RequestMapping("api/courses")
public class CourseController {

  @Autowired
  CourseService courseService;

  @Autowired
  StudentSessionService studentSessionService;
  
  @GetMapping("/student")
  public ResponseEntity<Object> signOut(@RequestHeader("student-session") String studentSessionId) {
      try {
          Student student = studentSessionService.getStudent(studentSessionId);
          List<CourseCard> courses = courseService.getCourses(student.getStudentId());
          return ResponseEntity.status(HttpStatus.OK).body(courses);
      } catch (Exception e) {
          e.printStackTrace();
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      } 
  }

}
