"use client"

import { getStudentClasses, getStudentInstituionClasses } from "@/services/StudentService";
import { useEffect, useState } from "react";

const Gradebook = () => {

  const [studentClasses, setStudentClasses] = useState(Array<any>);
  const [studentInstructorClasses, setStudentInstructorClasses] = useState(Array<any>);


  useEffect(() => {
    const fetchData = async () => {
      const studentClasses = await getStudentClasses();
      const instructorClasses = await getStudentInstituionClasses();
      setStudentClasses(studentClasses.data);
      setStudentInstructorClasses(instructorClasses.data);
    }

    fetchData();
  }, [])
  

  return (
    <>
      <h3 className="text-4xl">My Classes</h3>
      <div className="grid lg:grid-cols-3 sm:grid-cols-1 md:grid-cols-2">
        {studentClasses.map((sc, index) => (
          <div key={index} className="bg-indigo-300 m-3 p-2 shadow-lg rounded-sm">
            <p>{sc.name}</p>           
            <p>{sc.description}</p>
            <p>{sc.category}</p>
            <p>Grade: 92.1%</p>
            <p><a href="#">View Class</a></p>
          </div>
        ))}
      </div>
      <button className="p-4 border m-3 bg-green-700 w-28">Add Class</button>
      {studentInstructorClasses.length > 0 && 
        <h3 className="text-4xl">Blah Blah Classes</h3> }
        <div className="grid lg:grid-cols-3 sm:grid-cols-1 md:grid-cols-2">
        {studentInstructorClasses.map((sic, index) => (
          <div key={index} className="bg-indigo-300 m-3 p-2 shadow-lg rounded-sm">
            <p>{sic.name}</p>           
            <p>{sic.description}</p>
            <p>{sic.category}</p>
            <p>Grade: 92.1%</p>
            <p><a href="#">View Class</a></p>
          </div>
        ))}
        </div>
    </>
  )
}

export default  Gradebook;