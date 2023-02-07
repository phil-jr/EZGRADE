import React, { useState } from 'react';
import { signUpStudent } from '../../services/StudentService';
import './index.css'

interface FormValues {
  firstName: string;
  lastName: string;
  username: string;
  email: string;
  password: string;
  retypePassword: string;
}

const SignUp: React.FC = () => {
  const [formValues, setFormValues] = useState<FormValues>({
    firstName: '',
    lastName: '',
    username: '',
    email: '',
    password: '',
    retypePassword: ''
  });

  const handleInputChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = event.target;
    setFormValues({ ...formValues, [name]: value });
  };

  const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    const res = await signUpStudent({
      firstName: "Betty",
      lastName: "White",
      email: "bw@em.com",
      password: "pword",
    });

    console.log(res);
    // Add logic to handle the form submission here
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label htmlFor="firstName">First Name:</label>
        <input
          type="text"
          id="firstName"
          name="firstName"
          value={formValues.firstName}
          onChange={handleInputChange}
        />
      </div>
      <div>
        <label htmlFor="lastName">Last Name:</label>
        <input
          type="text"
          id="lastName"
          name="lastName"
          value={formValues.lastName}
          onChange={handleInputChange}
        />
      </div>
      <div>
        <label htmlFor="username">Username:</label>
        <input
          type="text"
          id="username"
          name="username"
          value={formValues.username}
          onChange={handleInputChange}
        />
      </div>
      <div>
        <label htmlFor="email">Email:</label>
        <input
          type="email"
          id="email"
          name="email"
          value={formValues.email}
          onChange={handleInputChange}
        />
      </div>
      <div>
        <label htmlFor="password">Password:</label>
        <input
          type="password"
          id="password"
          name="password"
          value={formValues.password}
          onChange={handleInputChange}
        />
      </div>
      <div>
        <label htmlFor="retypePassword">Retype Password:</label>
        <input
          type="password"
          id="retypePassword"
          name="retypePassword"
          value={formValues.retypePassword}
          onChange={handleInputChange}
        />
      </div>
      <button type="submit">Sign Up</button>
    </form>
  );
};

export default SignUp;
