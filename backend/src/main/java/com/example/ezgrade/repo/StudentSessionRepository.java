package com.example.ezgrade.repo;

import static com.example.ezgrade.constants.StudentSessionsSql.SELECT_STUDENT_BY_SESSION_ID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.ezgrade.mapper.StudentMapper;
import com.example.ezgrade.model.Student;

@Repository
public class StudentSessionRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Student getStudent(String studentSessionId) {

        try {
            Student student = jdbcTemplate.queryForObject(SELECT_STUDENT_BY_SESSION_ID, new StudentMapper(), studentSessionId);
            return student;
        } catch (Exception e) {
            return null;
        }
        
    }
}
