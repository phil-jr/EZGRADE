package com.example.ezgrade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ezgrade.model.Student;
import com.example.ezgrade.model.StudentClass;
import com.example.ezgrade.services.StudentClassService;
import com.example.ezgrade.services.StudentSessionService;

@RestController
@RequestMapping("api/student-classes")
public class StudentClassController {

    @Autowired
    StudentClassService studentClassService;

    @Autowired
    StudentSessionService studentSessionService;

    @PostMapping("/add")
    public ResponseEntity<StudentClass> add(@RequestBody StudentClass studentClass,  @RequestHeader("student-session") String studentSessionId) {
        try {
            Student student = studentSessionService.getStudent(studentSessionId);
            studentClass.setStudentId(student.getStudentId());
            return studentClassService.addClass(studentClass);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }    
    }

    @DeleteMapping("/remove")
    public ResponseEntity<StudentClass> remove(@RequestBody StudentClass studentClass,  @RequestHeader("student-session") String studentSessionId) {
        try {
            Student student = studentSessionService.getStudent(studentSessionId);
            studentClass.setStudentId(student.getStudentId());
            return studentClassService.removeClass(studentClass);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }    
    }

}
