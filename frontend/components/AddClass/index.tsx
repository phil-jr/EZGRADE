"use client"

import { Course } from "@/models/Course";
import { Section } from "@/models/Section";
import { useEffect, useState } from "react";

const AddClass = () => {

  const [course, setCourse] = useState<Course>({
    courseName: "",
    category: "",
    description: "",
    sections: [{
      name: "",
      weight: ""
    }]
  });

  useEffect(() => {
    console.log(course);
  }, [course])

  const addSection = () => {
    let sections = course.sections;
    sections.push({
      name: "",
      weight: ""
    })

    setCourse({
      ...course,
      sections
    });
  }

  const removeSection = (i: number) => {
    let sections = course.sections;
    sections.splice(i, 1);
    setCourse({
      ...course,
      sections
    });
  }

  const sectionChange = (e: any, i: number) => {
    console.log("HELLO")
    let sections = course.sections;
    sections[i] = {
      ...sections[i],
      [e.target.name]: e.target.value
    };
    setCourse({
      ...course,
      sections
    });
  }

  const changeCourse = (e: any) => {
    setCourse({
      ...course,
      [e.target.name]: e.target.value
    })
  }

  const addClass = () => {
    console.log(course);
  }

  return (
    <div className="lg:w-4/12 md:w-8/12 mx-auto sm:w-full">
      <h1 className="text-5xl">Add Class</h1>
      <input type="text" 
             placeholder="Name" 
             className="default-input m-2"
             value={course?.courseName}
             name="courseName"
             onChange={(e) => changeCourse(e)}/>
      <input type="text" 
             placeholder="Category" 
             className="default-input m-2"
             value={course?.category}
             name="category"
             onChange={(e) => changeCourse(e)}/>
      <input type="text" 
             placeholder="Description" 
             className="default-input m-2"
             value={course?.description}
             name="description"
             onChange={(e) => changeCourse(e)}/>
      <h1 className="mt-6 text-2xl">Sections</h1>
      {course.sections.map((section: Section, index: number) => (
        <div key={index} className="flex">
          <input type="text" 
             placeholder="Section" 
             className="section-input"
             name="name"
             value={course?.sections[index].name}
             onChange={(e) => sectionChange(e, index)}/>
          <input type="number" 
             placeholder="Weight" 
             className="section-input w-24"
             name="weight"
             value={course?.sections[index].weight}
             onChange={(e) => sectionChange(e, index)}/>  
          <button className="m-2 p-2 border bg-red-500 rounded" onClick={() => removeSection(index)}>Remove</button>
        </div>
      ))}
      <button onClick={addSection} className="m-2 border p-2 bg-green-600 rounded">Add Section</button><br />
      <button onClick={addClass} className="block mx-auto border p-4 px-32 bg-gray-600 rounded text-white">Add Class</button>
    </div>
  )
}

export default AddClass;