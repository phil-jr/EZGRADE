"use client"

import { getStudentClasses, getStudentInstituionClasses } from "@/services/StudentService";
import { useEffect, useState } from "react";

const Gradebook = () => {

  const [courses, setCourses] = useState<any>({
    studentCourses: [],
    institutionCourses: []
  });
  const [studentInstructorClasses, setStudentInstructorClasses] = useState(Array<any>);


  useEffect(() => {
    const fetchData = async () => {
      const courseData = await getStudentClasses();
      setCourses(courseData.data);
      console.log(courseData)
    }

    fetchData();
  }, [])
  

  return (
    <div>
      <h3 className="text-4xl">My Classes</h3>
      <div className="grid lg:grid-cols-3 sm:grid-cols-1 md:grid-cols-2">
        {courses.studentCourses.map((sc: any, index: any) => (
          <div key={index} className="bg-indigo-300 m-3 p-2 shadow-lg rounded-sm">
            <p>{sc.name}</p>           
            <p>{sc.description}</p>
            <p>{sc.category}</p>
            <p>Grade: {sc.grade}%</p>
            <p><a href="#">View Class</a></p>
          </div>
        ))}
      </div>
      <button className="p-4 border m-3 bg-green-700 w-28">Add Class</button>
      {courses.institutionCourses.length > 0 && <h3 className="text-4xl">Instituion Classes</h3>}
      {courses.institutionCourses.map((sc: any, index: any) => (
        <div key={index}>
          <h1 className="text-2xl mt-6">{sc.institutionName}</h1>
          <div className="grid lg:grid-cols-3 sm:grid-cols-1 md:grid-cols-2">
          {sc.courses.map((sc: any, index: any) => (
            <div key={index} className="bg-indigo-300 m-3 p-2 shadow-lg rounded-sm">
              <p>{sc.name}</p>           
              <p>{sc.description}</p>
              <p>{sc.category}</p>
              <p>Grade: {sc.grade}%</p>
              <p><a href="#">View Class</a></p>
            </div>
          ))}
          {sc.courses.map((sc: any, index: any) => (
            <div key={index} className="bg-indigo-300 m-3 p-2 shadow-lg rounded-sm">
              <p>{sc.name}</p>           
              <p>{sc.description}</p>
              <p>{sc.category}</p>
              <p>Grade: {sc.grade}%</p>
              <p><a href="#">View Class</a></p>
            </div>
          ))}
          {sc.courses.map((sc: any, index: any) => (
            <div key={index} className="bg-indigo-300 m-3 p-2 shadow-lg rounded-sm">
              <p>{sc.name}</p>           
              <p>{sc.description}</p>
              <p>{sc.category}</p>
              <p>Grade: {sc.grade}%</p>
              <p><a href="#">View Class</a></p>
            </div>
          ))}
          {sc.courses.map((sc: any, index: any) => (
            <div key={index} className="bg-indigo-300 m-3 p-2 shadow-lg rounded-sm">
              <p>{sc.name}</p>           
              <p>{sc.description}</p>
              <p>{sc.category}</p>
              <p>Grade: {sc.grade}%</p>
              <p><a href="#">View Class</a></p>
            </div>
          ))}
          {sc.courses.map((sc: any, index: any) => (
            <div key={index} className="bg-indigo-300 m-3 p-2 shadow-lg rounded-sm">
              <p>{sc.name}</p>           
              <p>{sc.description}</p>
              <p>{sc.category}</p>
              <p>Grade: {sc.grade}%</p>
              <p><a href="#">View Class</a></p>
            </div>
          ))}
          </div>
        </div>
      ))}

    </div>
  )
}

export default  Gradebook;