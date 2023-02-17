const studentOptions =  {
  headers: {
    "student-session": localStorage.getItem("student-session")
  }
}


export const getStudentOptions = () => {
  return {
    headers: {
      "student-session": localStorage.getItem("student-session")
    }
  }
}