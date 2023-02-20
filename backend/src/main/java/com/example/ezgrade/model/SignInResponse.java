package com.example.ezgrade.model;

public class SignInResponse extends GenericResponse {
  public SignInResponse(){
    super();
  }

  private String sessionId;
  private Student student;

  public String getSessionId() {
    return sessionId;
  }

  public void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

}
