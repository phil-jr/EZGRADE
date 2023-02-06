import axios from 'axios';
import SignUpData from '../models/SignUpData';

export const signUpService = async (data: SignUpData) => {
  try {
    const response = await axios.post('api/signup', data);
    return response.data;
  } catch (error) {
    throw error;
  }
};
