package com.example.ezgrade.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.ezgrade.model.StudentClass;
import com.example.ezgrade.util.RandomUtil;

import static com.example.ezgrade.constants.StudentClassesSql.INSERT_CLASS;
import static com.example.ezgrade.constants.StudentClassesSql.REMOVE_CLASS;

@Repository
public class StudentClassRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    RandomUtil randomUtil;
    
    public ResponseEntity<StudentClass> addClass(StudentClass studentClass) {

        try {

            studentClass.setStudentClassId(randomUtil.getSaltString(16));
            jdbcTemplate.update(INSERT_CLASS, new Object[]{
                studentClass.getStudentClassId(), 
                studentClass.getStudentId(), 
                studentClass.getName(),
                studentClass.getDescription(), 
                studentClass.getCategory(), 
                studentClass.getSubCategory()
            });

            return ResponseEntity.status(HttpStatus.CREATED).build();
        
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    public ResponseEntity<StudentClass> removeClass(StudentClass studentClass) {

        try {

            studentClass.setStudentClassId(randomUtil.getSaltString(16));
            jdbcTemplate.update(REMOVE_CLASS, new Object[]{
                studentClass.getStudentClassId()
            });

            return ResponseEntity.status(HttpStatus.OK).build();
        
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
