package com.example.ezgrade.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.ezgrade.model.CourseResponse.CourseCard;

public class CourseCardInstructorMapper implements RowMapper<CourseCard> {
  

  @Override
  public CourseCard mapRow(ResultSet rs, int rowNum) throws SQLException {
      CourseCard courseCard = new CourseCard();
      courseCard.setName(rs.getString("course_name"));
      courseCard.setDescription(rs.getString("course_description"));
      courseCard.setGrade(rs.getFloat("grade"));
      courseCard.setInstitution(rs.getString("instituion_name"));
      return courseCard;
  }

}