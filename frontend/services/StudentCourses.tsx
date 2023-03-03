import { Course } from '@/models/Course';
import axios from 'axios';

export const signUpStudent = (course: Course) => {
  return axios.post('http://localhost:8080/api/students/signup', course);
}