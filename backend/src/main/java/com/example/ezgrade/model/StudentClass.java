package com.example.ezgrade.model;

import java.sql.Timestamp;

public class StudentClass {
    private String studentClassId;
    private String studentId;
    private String name;
    private String description;
    private String category;
    private String subCategory;
    private String active;
    private Timestamp creationDate;
  
    public StudentClass(){}

    public StudentClass(String studentClassId, String studentId, String name, String description, String category, String subCategory, String active, Timestamp creationDate) {
      this.studentClassId = studentClassId;
      this.studentId = studentId;
      this.name = name;
      this.description = description;
      this.category = category;
      this.subCategory = subCategory;
      this.active = active;
      this.creationDate = creationDate;
    }
  
    public String getStudentClassId() {
      return studentClassId;
    }
  
    public void setStudentClassId(String studentClassId) {
      this.studentClassId = studentClassId;
    }
  
    public String getStudentId() {
      return studentId;
    }
  
    public void setStudentId(String studentId) {
      this.studentId = studentId;
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
  
