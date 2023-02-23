package com.example.ezgrade.model;

import java.sql.Timestamp;

public class Institution {
  private String institutionId;
  private String name;
  private String address;
  private String city;
  private String state;
  private String zipCode;
  private String website;
  private String phoneNumber;
  private Timestamp creationDate;

  public Institution(){}

  public String getInstitutionId() {
    return institutionId;
  }
  public void setInstitutionId(String institutionId) {
    this.institutionId = institutionId;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
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
  public String getZipCode() {
    return zipCode;
  }
  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }
  public String getWebsite() {
    return website;
  }
  public void setWebsite(String website) {
    this.website = website;
  }
  public String getPhoneNumber() {
    return phoneNumber;
  }
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
  public Timestamp getCreationDate() {
    return creationDate;
  }
  public void setCreationDate(Timestamp creationDate) {
    this.creationDate = creationDate;
  }

  

}
