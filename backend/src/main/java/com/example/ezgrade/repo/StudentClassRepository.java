package com.example.ezgrade.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.ezgrade.model.GenericResponse;
import com.example.ezgrade.model.StudentClass;
import com.example.ezgrade.util.RandomUtil;

import static com.example.ezgrade.constants.StudentClassesSql.INSERT_CLASS;
import static com.example.ezgrade.constants.StudentClassesSql.REMOVE_CLASS;
import static com.example.ezgrade.constants.StudentClassesSql.SELECT_STUDENT_CLASSES_BY_STUDENT_ID;

import com.example.ezgrade.constants.ReturnStatus;
import com.example.ezgrade.mapper.StudentClassMapper;
import com.example.ezgrade.mapper.StudentMapper;
import com.example.ezgrade.constants.ResponseMessage;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentClassRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    RandomUtil randomUtil;
    
    public GenericResponse addClass(StudentClass studentClass) {

        List<String> errors = new ArrayList<String>();
        GenericResponse res = new GenericResponse(ReturnStatus.OK, null);

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

            return res;
        
        } catch (Exception e) {
            e.printStackTrace();
            errors.add(ResponseMessage.BASE_ERROR);
            res.setStatus(ReturnStatus.ERROR);
            res.setErrors(errors);
            return res;
        }
    }

    public GenericResponse removeClass(StudentClass studentClass) {
        List<String> errors = new ArrayList<String>();
        GenericResponse res = new GenericResponse(ReturnStatus.OK, null);
        try {

            studentClass.setStudentClassId(randomUtil.getSaltString(16));
            jdbcTemplate.update(REMOVE_CLASS, new Object[]{
                studentClass.getStudentClassId()
            });

            return res;
        
        } catch (Exception e) {
            errors.add(ResponseMessage.BASE_ERROR);
            res.setStatus(ReturnStatus.ERROR);
            res.setErrors(errors);
            return res;
        }
    }

    public List<StudentClass> getStudentClassesByStudentId(String studentId) {
        
        List<StudentClass> studentClasses;
        try {

            studentClasses = jdbcTemplate.query(SELECT_STUDENT_CLASSES_BY_STUDENT_ID, new StudentClassMapper(), new Object[]{studentId});
            return studentClasses;
        
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
