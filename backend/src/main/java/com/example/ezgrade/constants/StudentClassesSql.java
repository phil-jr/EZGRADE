package com.example.ezgrade.constants;

public class StudentClassesSql {
    
    private StudentClassesSql() {
        // restrict instantiation
    }

    public static final String INSERT_CLASS =  "INSERT INTO student_classes VALUES (?, ?, ?, ?, ?, ?, 'active', NOW())";

    public static final String REMOVE_CLASS =  "UPDATE student_classes SET active = FALSE WHERE student_classs_id = ? AND student_id = ?";

}
