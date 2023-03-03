package com.example.ezgrade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ezgrade.model.Course;
import com.example.ezgrade.model.GenericResponse;
import com.example.ezgrade.model.Student;
import com.example.ezgrade.model.CourseResponse.CourseResponse;
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
    public ResponseEntity<CourseResponse> signOut(@RequestHeader("student-session") String studentSessionId) {
        try {
            Student student = studentSessionService.getStudent(studentSessionId);
            CourseResponse courseResponse = courseService.getCourses(student.getStudentId());
            return ResponseEntity.status(HttpStatus.OK).body(courseResponse);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } 
    }

    @PostMapping("/add-course")
    public ResponseEntity<GenericResponse> addCourse(@RequestHeader("student-session") String studentSessionId, @RequestBody Course course) {
        try {
            Student student = studentSessionService.getStudent(studentSessionId);
            GenericResponse res = courseService.addStudentCourse(course);
            return ResponseEntity.status(HttpStatus.OK).body(res);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } 
    }

}
