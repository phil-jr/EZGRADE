package com.example.ezgrade.repo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.ezgrade.mapper.CourseCardInstructorMapper;
import com.example.ezgrade.mapper.CourseCardStudentMapper;
import com.example.ezgrade.model.CourseResponse.CourseCard;
import com.example.ezgrade.model.CourseResponse.CourseResponse;
import com.example.ezgrade.model.CourseResponse.InstructorCourses;

import static com.example.ezgrade.constants.CourseCardSql.SELECT_STUDENT_COURSE_CARD;
import static com.example.ezgrade.constants.CourseCardSql.SELECT_INSTRUCTOR_COURSE_CARD;

@Repository
public class CourseRepository implements CourseRepositoryInterface {

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Override
  public CourseResponse getCoursesForGradebook(String studentId) {

    List<CourseCard> studentCourseList = jdbcTemplate.query(SELECT_STUDENT_COURSE_CARD, 
                                                         new CourseCardStudentMapper(), 
                                                         new Object[]{studentId});

    List<CourseCard> instructorCoursesList= jdbcTemplate.query(SELECT_INSTRUCTOR_COURSE_CARD, 
                                                            new CourseCardInstructorMapper(), 
                                                            new Object[]{studentId});

    

    CourseResponse courseResponse = new CourseResponse();
    courseResponse.setStudentCourses(studentCourseList);

    ArrayList<InstructorCourses> instructorCourses = new ArrayList<InstructorCourses>();

    HashSet<String> instituions = new HashSet<String>();
    for(int i = 0; i < instructorCoursesList.size(); i++) {
      instituions.add(instructorCoursesList.get(i).getInstitution());
    }

    for (String instituion : instituions) { 
      List<CourseCard> courseCards = instructorCoursesList.stream()
                                                          .filter(x -> x.getInstitution().equals(instituion))
                                                          .collect(Collectors.toList()); 
      
      instructorCourses.add(new InstructorCourses(instituion, courseCards));
    }

    courseResponse.setInstitutionCourses(instructorCourses);

    return courseResponse;
  }
  
}


/*
 * 
 * 
 * {
 *  studentCourses: [
 *    {
 *      "blah": "hih"
 *    }
 *  ],
 *  institutionCourses: [
 *    {
 *      intituionName: "Georgia Southern University",
 *      courses: [
 *        {
 *          "courseName": "MathI"
 *        }
*       ]
 *    }
 *  ]
 * }
 * 
 * 
*/