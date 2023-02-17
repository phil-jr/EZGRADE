package com.example.ezgrade.model;

public class SignInResponse extends GenericResponse {
  public SignInResponse(){
    super();
  }

  private String sessionId;

  public String getSessionId() {
    return sessionId;
  }

  public void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }

}
