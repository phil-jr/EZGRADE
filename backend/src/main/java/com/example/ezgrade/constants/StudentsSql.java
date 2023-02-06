package com.example.ezgrade.constants;

public class StudentsSql {

    private StudentsSql() {
        // restrict instantiation
    }

    public static final String INSERT_STUDENT =  "INSERT INTO students VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW())";

    public static final String SIGN_IN_STUDENT = "SELECT student_id, email, password FROM students WHERE email = ?";

    public static final String INSERT_STUDENT_TOKEN = "INSERT INTO student_sessions VALUES (?, ?, NOW(), NULL)";


    
}


