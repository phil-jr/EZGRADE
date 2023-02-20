package com.example.ezgrade.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ezgrade.model.GenericResponse;
import com.example.ezgrade.model.Student;
import com.example.ezgrade.model.StudentClass;
import com.example.ezgrade.services.StudentClassService;
import com.example.ezgrade.services.StudentService;
import com.example.ezgrade.services.StudentSessionService;

@RestController
@RequestMapping("api/student-classes")
public class StudentClassController {

    @Autowired
    StudentClassService studentClassService;

    @Autowired
    StudentSessionService studentSessionService;

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<GenericResponse> add(@RequestBody StudentClass studentClass,  @RequestHeader("student-session") String studentSessionId) {
        try {
            Student student = studentSessionService.getStudent(studentSessionId);
            studentClass.setStudentId(student.getStudentId());
            GenericResponse res = studentClassService.addClass(studentClass);
            return ResponseEntity.status(HttpStatus.OK).body(res);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }    
    }

    @DeleteMapping("/remove")
    public ResponseEntity<GenericResponse> remove(@RequestBody StudentClass studentClass, @RequestHeader("student-session") String studentSessionId) {
        try {
            Student student = studentSessionService.getStudent(studentSessionId);
            studentClass.setStudentId(student.getStudentId());
            GenericResponse res = studentClassService.removeClass(studentClass);
            return ResponseEntity.status(HttpStatus.OK).body(res);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }    
    }

    @GetMapping("/get")
    public ResponseEntity<List<StudentClass>> getStudentClassesByStudentId(@RequestHeader("student-session") String studentSessionId) {
        try {
            Student sessionStudent = studentSessionService.getStudent(studentSessionId);
            List<StudentClass> studentClasses = studentClassService.getStudentClassesByStudentId(sessionStudent.getStudentId());
            return ResponseEntity.status(HttpStatus.OK).body(studentClasses);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }   
    }

}
