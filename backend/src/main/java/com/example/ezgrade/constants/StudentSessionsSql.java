package com.example.ezgrade.constants;

public class StudentSessionsSql {
    
    private StudentSessionsSql() {
        // restrict instantiation
    }

    public static final String SELECT_STUDENT_BY_SESSION_ID = "SELECT students.* FROM students INNER JOIN student_sessions ON students.student_id = student_sessions.student_id WHERE student_sessions.session_id = ?";
}
