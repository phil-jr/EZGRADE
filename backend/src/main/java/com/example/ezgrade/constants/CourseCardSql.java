package com.example.ezgrade.constants;

public class CourseCardSql {
     
  private CourseCardSql() {
    // restrict instantiation
  }

  public static final String SELECT_STUDENT_COURSE_CARD = "SELECT * FROM " +
                                                          "  ez_grade.courses " +
                                                          "  JOIN self_enrollments ON self_enrollments.course_id = courses.course_id " + 
                                                          "WHERE " +
                                                          "  self_enrollments.student_id = ?";


  public static final String SELECT_INSTRUCTOR_COURSE_CARD =  "SELECT " +
                                                              "   courses.course_id, " +
                                                              "   courses.name as course_name, " +
                                                              "   courses.description as course_description, " +
                                                              "   instructors.first_name as instructor_first_name, " +
                                                              "   instructors.last_name as instructor_last_name, " +
                                                              "   institutions.name as instituion_name, " +
                                                              "   grade " +
                                                              "FROM " +
                                                              "  ez_grade.courses " +
                                                              "  JOIN instructor_enrollments ON instructor_enrollments.course_id = courses.course_id " + 
                                                              "  JOIN instructors ON instructors.instructor_id = instructor_enrollments.instructor_id " + 
                                                              "  JOIN institutions ON institutions.institution_id = instructors.institution_id " +
                                                              "WHERE instructor_enrollments.student_id = ?";

}
