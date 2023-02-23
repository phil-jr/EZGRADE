package com.example.ezgrade.repo;

import java.util.List;

import com.example.ezgrade.model.Course;
import com.example.ezgrade.model.CourseResponse.CourseCard;

public interface CourseRepositoryInterface {
  public List<CourseCard> getCoursesForGradebook(String studentId);
}
