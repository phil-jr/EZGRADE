import axios from 'axios';
import { SignUpForm } from '@/models/SignUpForm';

export const signUpStudent = (signUpForm: SignUpForm) => {
  return axios.post('http://localhost:8080/api/students/signup', signUpForm)
}