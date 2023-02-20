package com.example.ezgrade.model;

import java.security.Timestamp;

public class InstructorClass {
  private String instructorClassId;
  private String instructorId;
  private String name;
  private String description;
  private String category;
  private String subCategory;
  private String active;
  private Timestamp creationDate;

  public InstructorClass(){}

  public String getInstructorClassId() {
    return instructorClassId;
  }
  public void setInstructorClassId(String instructorClassId) {
    this.instructorClassId = instructorClassId;
  }
  public String getInstructorId() {
    return instructorId;
  }
  public void setInstructorId(String instructorId) {
    this.instructorId = instructorId;
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
  public String getCategory() {
    return category;
  }
  public void setCategory(String category) {
    this.category = category;
  }
  public String getSubCategory() {
    return subCategory;
  }
  public void setSubCategory(String subCategory) {
    this.subCategory = subCategory;
  }
  public String getActive() {
    return active;
  }
  public void setActive(String active) {
    this.active = active;
  }
  public Timestamp getCreationDate() {
    return creationDate;
  }
  public void setCreationDate(Timestamp creationDate) {
    this.creationDate = creationDate;
  } 

  

}
