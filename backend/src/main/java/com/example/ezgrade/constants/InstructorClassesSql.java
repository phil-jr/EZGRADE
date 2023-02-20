package com.example.ezgrade.constants;

public class InstructorClassesSql {
  
  private InstructorClassesSql() {
    // restrict instantiation
  }

  public static final String SELECT_STUDENT_INSTITUTION_CLASSES = "SELECT * FROM institution_classes WHERE student_id = ? AND active = TRUE";

}
