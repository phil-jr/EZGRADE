package com.example.ezgrade.constants;

public class StudentsSql {

    private StudentsSql() {
        // restrict instantiation
    }

    public static final String INSERT_STUDENT =  "INSERT INTO students VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW())";

    public static final String SIGN_IN_STUDENT = "SELECT * FROM students WHERE email = ?";

    public static final String INSERT_STUDENT_TOKEN = "INSERT INTO student_sessions VALUES (?, ?, NOW(), NULL)";

    public static final String SELECT_STUDENT_BY_ID = "SELECT * FROM students WHERE student_id = ?";

    public static final String DELETE_STUDENT_SESSION = "DELETE FROM student_sessions WHERE session_id = ?";
    
}


