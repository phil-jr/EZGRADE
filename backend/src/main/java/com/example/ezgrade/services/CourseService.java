package com.example.ezgrade.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ezgrade.model.Course;
import com.example.ezgrade.model.GenericResponse;
import com.example.ezgrade.model.CourseResponse.CourseResponse;
import com.example.ezgrade.repo.CourseRepository;

@Service
public class CourseService {

  @Autowired
  CourseRepository courseRepository;
  
  public CourseResponse getCourses(String studentId) {
    return courseRepository.getCoursesForGradebook(studentId);
  }

  public GenericResponse addStudentCourse(Course course) {
    return courseRepository.addStudentCourse(course);
  }

}
