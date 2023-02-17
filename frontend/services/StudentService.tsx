import axios from 'axios';
import { SignUpForm } from '@/models/SignUpForm';
import { SignInForm } from '@/models/SignInForm';
import { getStudentOptions } from '@/util/headers';

export const signUpStudent = (signUpForm: SignUpForm) => {
  return axios.post('http://localhost:8080/api/students/signup', signUpForm)
}


export const signInStudent = (signInForm: SignInForm) => {
  return axios.post('http://localhost:8080/api/students/signin', signInForm)
}

export const signOutStudent = () => {
  const options = getStudentOptions();
  return axios.get("http://localhost:8080/api/students/signout", options)
}