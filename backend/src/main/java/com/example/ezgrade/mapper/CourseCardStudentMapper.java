package com.example.ezgrade.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.ezgrade.model.CourseResponse.CourseCard;

public class CourseCardStudentMapper implements RowMapper<CourseCard> {
  

  @Override
  public CourseCard mapRow(ResultSet rs, int rowNum) throws SQLException {
      CourseCard courseCard = new CourseCard();
      courseCard.setName(rs.getString("name"));
      courseCard.setDescription(rs.getString("description"));
      courseCard.setGrade(rs.getFloat("grade"));
      courseCard.setCreationDate(rs.getTimestamp("creation_date"));
      return courseCard;
  }

}