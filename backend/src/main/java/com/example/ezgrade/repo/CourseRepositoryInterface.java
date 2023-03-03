package com.example.ezgrade.repo;

import java.util.List;

import com.example.ezgrade.model.Course;
import com.example.ezgrade.model.GenericResponse;
import com.example.ezgrade.model.CourseResponse.CourseResponse;

public interface CourseRepositoryInterface {
  public CourseResponse getCoursesForGradebook(String studentId);
  public GenericResponse addStudentCourse(Course course);
}
