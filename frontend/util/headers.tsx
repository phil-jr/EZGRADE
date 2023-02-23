"use client"

export const getStudentOptions = () => {
  const studentSession = (typeof window !== 'undefined') ? 
                          localStorage.getItem("student-session") : 
                          null;
  return {
    headers: {
      "student-session": studentSession
    }
  }
}

export const removeLocalStorageItems = () => {
  (typeof window !== 'undefined') && localStorage.removeItem("student-session")
}