package com.example.ezgrade.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.ezgrade.model.StudentSession;

public class SessionMapper  implements RowMapper<StudentSession> {

    @Override
    public StudentSession mapRow(ResultSet rs, int rowNum) throws SQLException {
        StudentSession studentSession = new StudentSession();
        studentSession.setSessionId(rs.getString("session_id"));
        studentSession.setStudentId(rs.getString("student_id"));
        studentSession.setSignInTime(rs.getTimestamp("sign_in_time"));
        studentSession.setSignOutTime(rs.getTimestamp("sign_out_time"));
        return studentSession;
    }

}
