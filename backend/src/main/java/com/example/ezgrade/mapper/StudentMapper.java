package com.example.ezgrade.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.ezgrade.model.Student;

public class StudentMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setStudentId(rs.getString("student_id"));
        student.setAddress(rs.getString("address"));
        student.setCreationDate(rs.getDate("creation_date"));
        student.setEmail(rs.getString("email"));
        student.setFirstName(rs.getString("first_name"));
        student.setLastName(rs.getString("last_name"));
        student.setPassword(rs.getString("password"));
        student.setPhoneNumber(rs.getString("phone_number"));
        student.setState(rs.getString("state"));
        return student;
    }
}
