package com.example.ezgrade.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.ezgrade.mapper.CourseCardMapper;
import com.example.ezgrade.model.CourseResponse.CourseCard;

import static com.example.ezgrade.constants.CourseCardSql.SELECT_STUDENT_COURSE_CARD;
import static com.example.ezgrade.constants.CourseCardSql.SELECT_INSTRUCTOR_COURSE_CARD;

@Repository
public class CourseRepository implements CourseRepositoryInterface {

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Override
  public List<CourseCard> getCoursesForGradebook(String studentId) {

    List<CourseCard> studentCourses = jdbcTemplate.query(SELECT_STUDENT_COURSE_CARD, 
                                                         new CourseCardMapper(), 
                                                         new Object[]{studentId});

    List<CourseCard> instructorCourses = jdbcTemplate.query(SELECT_INSTRUCTOR_COURSE_CARD, 
                                                            new CourseCardMapper(), 
                                                            new Object[]{studentId});

    // TODO Auto-generated method stub
    return null;
  }
  
}
