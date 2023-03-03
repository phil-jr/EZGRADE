package com.example.ezgrade.model.CourseResponse;

import java.util.List;

public class CourseResponse {
  List<CourseCard> studentCourses;
  List<InstructorCourses> institutionCourses;

  public CourseResponse(){}

  public List<CourseCard> getStudentCourses() {
    return studentCourses;
  }
  
  public void setStudentCourses(List<CourseCard> studentCourses) {
    this.studentCourses = studentCourses;
  }

  public List<InstructorCourses> getInstitutionCourses() {
    return institutionCourses;
  }

  public void setInstitutionCourses(List<InstructorCourses> institutionCourses) {
    this.institutionCourses = institutionCourses;
  } 
  
}


// {
//   "studentCourses": [
//     {
//       "":"",
//       "":""
//     }
//   ],
//   "institutionCourses": [
//     {
//       "institution":"hello",
//       "courses": [
//         {
//           "":"",
//           "":""
//         }
//       ]
//     }
//   ]
// }