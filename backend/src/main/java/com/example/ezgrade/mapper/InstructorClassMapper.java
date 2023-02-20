package com.example.ezgrade.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.ezgrade.model.InstructorClass;

public class InstructorClassMapper implements RowMapper<InstructorClass> {
  @Override
  public InstructorClass mapRow(ResultSet rs, int rowNum) throws SQLException {
      InstructorClass institutionClass = new InstructorClass();

      return institutionClass;
  }
}
