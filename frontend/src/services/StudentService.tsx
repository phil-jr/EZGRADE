import axios from 'axios';
import SignUpData from '../models/SignUpData';

export const signUpStudent = async (data: SignUpData) => {
  try {
    const response = await axios.post(`${process.env.REACT_APP_API_ENDPOINT}/api/students/signup`, data);
    return response.data;
  } catch (error) {
    throw error;
  }
};
