package com.example.ezgrade.model;

import java.sql.Timestamp;

public class Course {

  private String courseId;
  private String name;
  private String description;
  private int categoryId;
  private int subCategoryId;
  private Timestamp creationDate;

  public Course(){}

  public String getCourseId() {
    return courseId;
  }
  public void setCourseId(String courseId) {
    this.courseId = courseId;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public int getCategoryId() {
    return categoryId;
  }
  public void setCategoryId(int categoryId) {
    this.categoryId = categoryId;
  }
  public int getSubCategoryId() {
    return subCategoryId;
  }
  public void setSubCategoryId(int subCategoryId) {
    this.subCategoryId = subCategoryId;
  }
  public Timestamp getCreationDate() {
    return creationDate;
  }
  public void setCreationDate(Timestamp creationDate) {
    this.creationDate = creationDate;
  }
  
  

}
