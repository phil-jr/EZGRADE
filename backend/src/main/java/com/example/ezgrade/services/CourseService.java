package com.example.ezgrade.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ezgrade.model.Course;
import com.example.ezgrade.model.CourseResponse.CourseCard;
import com.example.ezgrade.repo.CourseRepository;

@Service
public class CourseService {

  @Autowired
  CourseRepository courseRepository;
  
  public List<CourseCard> getCourses(String studentId) {
    return courseRepository.getCoursesForGradebook(studentId);
  }

}
