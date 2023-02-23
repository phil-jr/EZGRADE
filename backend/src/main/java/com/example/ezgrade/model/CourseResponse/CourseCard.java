package com.example.ezgrade.model.CourseResponse;

import com.example.ezgrade.model.Course;

public class CourseCard extends Course {

  public CourseCard(){
    super();
  }

  private float grade;
  private String instructorName;
  private String institution;
  
  public float getGrade() {
    return grade;
  }
  public void setGrade(float grade) {
    this.grade = grade;
  }
  public String getInstructorName() {
    return instructorName;
  }
  public void setInstructorName(String instructorName) {
    this.instructorName = instructorName;
  }
  public String getInstitution() {
    return institution;
  }
  public void setInstitution(String institution) {
    this.institution = institution;
  }

}
