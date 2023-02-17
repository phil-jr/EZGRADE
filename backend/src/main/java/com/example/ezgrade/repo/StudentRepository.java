package com.example.ezgrade.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.example.ezgrade.constants.ResponseMessage;
import com.example.ezgrade.constants.ReturnStatus;
import com.example.ezgrade.mapper.StudentMapper;
import com.example.ezgrade.model.GenericResponse;
import com.example.ezgrade.model.SignIn;
import com.example.ezgrade.model.SignInResponse;
import com.example.ezgrade.model.Student;
import com.example.ezgrade.util.RandomUtil;

import static com.example.ezgrade.constants.StudentsSql.INSERT_STUDENT;
import static com.example.ezgrade.constants.StudentsSql.SIGN_IN_STUDENT;
import static com.example.ezgrade.constants.StudentsSql.SELECT_STUDENT_BY_ID;
import static com.example.ezgrade.constants.StudentsSql.DELETE_STUDENT_SESSION;

import java.util.ArrayList;
import java.util.List;

import static com.example.ezgrade.constants.StudentsSql.INSERT_STUDENT_TOKEN;


@Repository
public class StudentRepository implements StudentRepositoryInterface {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    RandomUtil randomUtil;

    @Override
    public GenericResponse signUp(Student student) {

        List<String> errors = new ArrayList<String>();
        GenericResponse res = new GenericResponse(ReturnStatus.OK, null);

        try {
        
            student.setPassword(bCryptPasswordEncoder.encode(student.getPassword()));
            student.setStudentId(randomUtil.getSaltString(16));

            jdbcTemplate.update(INSERT_STUDENT, new Object[]{
                student.getStudentId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getPassword(),
                student.getPhoneNumber(),
                student.getAddress(),
                student.getCity(),
                student.getState(),
                student.getZipCode()
            });

            return res;

        } catch (Exception e) {
            errors.add(ResponseMessage.BASE_ERROR);
            res.setStatus(ReturnStatus.ERROR);
            res.setErrors(errors);
            return res;
        }
    }

    @Override
    public SignInResponse signIn(SignIn signIn) {

        List<String> errors = new ArrayList<String>();
        SignInResponse res = new SignInResponse();
        res.setErrors(errors);
        res.setStatus(ReturnStatus.OK);

        try {
            String email = signIn.getEmail();
            Student ret = new Student(); 
            Student student = jdbcTemplate.queryForObject(SIGN_IN_STUDENT, (rs, rowNum) -> {
                ret.setStudentId(rs.getString("student_id"));
                ret.setEmail(rs.getString("email"));
                ret.setPassword(rs.getString("password"));
                return ret;
            }, email);

            if (student == null) throw new Exception();

            CharSequence charPassword = signIn.getPassword();
            boolean validSignIn = bCryptPasswordEncoder.matches(charPassword, student.getPassword());
            
            if (!validSignIn) throw new Exception();

            String studentSession = randomUtil.getSaltString(32);

            jdbcTemplate.update(INSERT_STUDENT_TOKEN, new Object[]{
                studentSession,
                student.getStudentId()
            });

            res.setSessionId(studentSession);
            return res;

        } catch (Exception e) {
            errors.add(ResponseMessage.BASE_ERROR);
            res.setStatus(ReturnStatus.ERROR);
            res.setErrors(errors);
            return res;
        }
    }

    @Override
    public GenericResponse signOut(String sessionId) {

        List<String> errors = new ArrayList<String>();
        GenericResponse res = new GenericResponse(ReturnStatus.OK, errors);

        try {
            jdbcTemplate.update(DELETE_STUDENT_SESSION, new Object[]{ sessionId });
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            errors.add(ResponseMessage.BASE_ERROR);
            res.setStatus(ReturnStatus.ERROR);
            res.setErrors(errors);
            return res;
        }
    }

    @Override
    public Student getStudent(String studentId) {
        try {
            Student student = jdbcTemplate.queryForObject(SELECT_STUDENT_BY_ID, new StudentMapper(), studentId);
            return student;
        } catch (Exception e) {
            return null;
        }
    }
    
}
