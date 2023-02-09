package com.example.ezgrade.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.ezgrade.model.StudentClass;

public class StudentClassMapper  implements RowMapper<StudentClass> {
    @Override
    public StudentClass mapRow(ResultSet rs, int rowNum) throws SQLException {
        StudentClass studentClass = new StudentClass();
        studentClass.setCategory(rs.getString("category"));
        studentClass.setCreationDate(rs.getTimestamp("creation_date"));
        studentClass.setDescription(rs.getString("description"));
        studentClass.setName(rs.getString("name"));
        return studentClass;
    }
}
