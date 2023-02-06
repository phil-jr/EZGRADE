package com.example.ezgrade.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
    @Column(name = "student_id")
    private String studentId;

    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;
    
    @Column(name = "password")
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;
    
    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "creation_date")
    private Date creationDate;
    
    // Constructors
    public Student(String studentId, String firstName, String lastName, String email, String password, String address,
        String city, String state, String zipcode, Date creationDate) {
      this.studentId = studentId;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.password = password;
      this.address = address;
      this.city = city;
      this.state = state;
      this.zipcode = zipcode;
      this.creationDate = creationDate;
    }

    public Student (){}

    // Getters and setters for each field
    public String getStudentId() {
      return studentId;
    }

    public void setStudentId(String studentId) {
      this.studentId = studentId;
    }
  
    public String getFirstName() {
      return firstName;
    }
  
    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }
  
    public String getLastName() {
      return lastName;
    }
  
    public void setLastName(String lastName) {
      this.lastName = lastName;
    }
  
    public String getEmail() {
      return email;
    }
  
    public void setEmail(String email) {
      this.email = email;
    }
  
    public String getPassword() {
      return password;
    }
  
    public void setPassword(String password) {
      this.password = password;
    }
  
    public String getPhoneNumber() {
      return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
      return address;
    }
  
    public void setAddress(String address) {
      this.address = address;
    }
  
    public String getCity() {
      return city;
    }
  
    public void setCity(String city) {
      this.city = city;
    }
  
    public String getState() {
      return state;
    }
  
    public void setState(String state) {
      this.state = state;
    }
  
    public String getZipcode() {
      return zipcode;
    }
  
    public void setZipcode(String zipcode) {
      this.zipcode = zipcode;
    }

    public Date getCreationDate() {
      return creationDate;
    }

    public void setCreationDate(Date creationDate) {
      this.creationDate = creationDate;
    }

}
  