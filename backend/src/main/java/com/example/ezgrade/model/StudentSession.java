package com.example.ezgrade.model;

import java.sql.Timestamp;

public class StudentSession {
    private String sessionId;
    private String studentId;
    private Timestamp signInTime;
    private Timestamp signOutTime;

    public StudentSession(){}
  
    public StudentSession(String studentId, Timestamp signInTime) {
      this.studentId = studentId;
      this.signInTime = signInTime;
    }
  
    public String getSessionId() {
      return sessionId;
    }
  
    public void setSessionId(String sessionId) {
      this.sessionId = sessionId;
    }
  
    public String getStudentId() {
      return studentId;
    }
  
    public void setStudentId(String studentId) {
      this.studentId = studentId;
    }
  
    public Timestamp getSignInTime() {
      return signInTime;
    }
  
    public void setSignInTime(Timestamp signInTime) {
      this.signInTime = signInTime;
    }
  
    public Timestamp getSignOutTime() {
      return signOutTime;
    }
  
    public void setSignOutTime(Timestamp signOutTime) {
      this.signOutTime = signOutTime;
    }
  }
  
