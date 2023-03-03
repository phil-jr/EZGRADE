package com.example.ezgrade.model.CourseResponse;

import java.util.List;

public class InstructorCourses {
  
  private String institutionName;
  private List<CourseCard> courses;

  public InstructorCourses(){}

  public InstructorCourses(String institutionName, List<CourseCard> courses) {
    this.institutionName = institutionName;
    this.courses = courses;
  }

  public String getInstitutionName() {
    return institutionName;
  }
  public void setInstitutionName(String institutionName) {
    this.institutionName = institutionName;
  }
  public List<CourseCard> getCourses() {
    return courses;
  }
  public void setCourses(List<CourseCard> courses) {
    this.courses = courses;
  }

  

}
