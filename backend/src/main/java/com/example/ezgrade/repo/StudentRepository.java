package com.example.ezgrade.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.example.ezgrade.model.SignIn;
import com.example.ezgrade.model.Student;
import com.example.ezgrade.util.RandomUtil;

import static com.example.ezgrade.constants.StudentsSql.INSERT_STUDENT;
import static com.example.ezgrade.constants.StudentsSql.SIGN_IN_STUDENT;
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
    public ResponseEntity<Student> signUp(Student student) {

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
                student.getZipcode()
            });

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<Student> signIn(SignIn signIn) {

        ResponseEntity<Student> failResponse = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        
        try {
            String email = signIn.getEmail();
            Student ret = new Student(); 
            Student student = jdbcTemplate.queryForObject(SIGN_IN_STUDENT, (rs, rowNum) -> {
                ret.setStudentId(rs.getString("student_id"));
                ret.setEmail(rs.getString("email"));
                ret.setPassword(rs.getString("password"));
                return ret;
            }, email);

            if (student == null) return failResponse;

            CharSequence charPassword = signIn.getPassword();
            boolean validSignIn = bCryptPasswordEncoder.matches(charPassword, student.getPassword());
            
            if (!validSignIn) return failResponse;

            jdbcTemplate.update(INSERT_STUDENT_TOKEN, new Object[]{
                randomUtil.getSaltString(32),
                student.getStudentId()
            });

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();

    }
    
}
