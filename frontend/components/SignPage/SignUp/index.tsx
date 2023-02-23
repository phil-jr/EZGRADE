"use client"

import { SignUpForm } from "@/models/SignUpForm";
import { signUpStudent } from "@/services/StudentService";
import { FC, useState } from "react"

const SignUp: FC = () => {

    const inputStyle = "border border-slate-400 block rounded-sm w-full h-12 p-2";
    const wrapperStyle = "mx-auto block w-10/12 my-2 max-w-lg";

    const [signUpStudentForm, setsignUpStudentForm] = useState<SignUpForm>({
        firstName: "",
        lastName: "",
        email: "",
        phoneNumber: "",
        address: "",
        city: "",
        state: "",
        zipCode: "",
        password: ""
    })

    const valueChange = (e: any) => {
        setsignUpStudentForm({
            ...signUpStudentForm,
            [e.target.name]: e.target.value
        });
    }

    const signUp = async () => {
        let res = await signUpStudent(signUpStudentForm);
        console.log(res.data);
    }

    return (
        <div className="flex flex-col sm:w-3/5 max-w-xl w-full mr-auto ml-auto">
            <h1 className="mx-auto p-4 text-2xl font-bold">Sign Up for EzGrade</h1>       
            <div className={wrapperStyle}>
                {/* <label htmlFor="firstName" className="font-bold text-lg">First Name:</label> */}
                <input type="text" 
                        value={signUpStudentForm.firstName} 
                        name="firstName" 
                        onChange={e => valueChange(e)}
                        className={inputStyle}
                        placeholder="First Name"
                />
            </div>    
            <div className={wrapperStyle}>
                {/* <label htmlFor="lastName" className="font-bold text-lg">Last Name:</label> */}
                <input type="text" 
                        value={signUpStudentForm.lastName} 
                        name="lastName" 
                        onChange={e => valueChange(e)}
                        className={inputStyle}
                        placeholder="Last Name"
                />
            </div>
            <div className={wrapperStyle}>
                {/* <label htmlFor="email" className="font-bold text-lg">Email:</label> */}
                <input type="email" 
                        value={signUpStudentForm.email} 
                        name="email" 
                        onChange={e => valueChange(e)}
                        className={inputStyle}
                        placeholder="Email"
                />
            </div>
            <div className={wrapperStyle}>
                {/* <label htmlFor="phoneNumber" className="font-bold text-lg">Phone Number:</label> */}
                <input type="text" 
                        value={signUpStudentForm.phoneNumber} 
                        name="phoneNumber" 
                        onChange={e => valueChange(e)}
                        className={inputStyle}
                        placeholder="Phone Number"
                />
            </div>
            <div className={wrapperStyle}>
                {/* <label htmlFor="city" className="font-bold text-lg">City:</label> */}
                <input type="text" 
                        value={signUpStudentForm.city} 
                        name="city" 
                        onChange={e => valueChange(e)}
                        className={inputStyle}
                        placeholder="City"
                />
            </div>
            <div className={wrapperStyle}>
                {/* <label htmlFor="state" className="font-bold text-lg">State:</label> */}
                <input type="text" 
                        value={signUpStudentForm.state} 
                        name="state" 
                        onChange={e => valueChange(e)}
                        className={inputStyle}
                        placeholder="State"
                />
            </div>
            <div className={wrapperStyle}>
                {/* <label htmlFor="zipCode" className="font-bold text-lg">Zip Code:</label> */}
                <input type="text" 
                        value={signUpStudentForm.zipCode} 
                        name="zipCode" 
                        onChange={e => valueChange(e)}
                        className={inputStyle}
                        placeholder="Zip Code"
                />
            </div>
            <div className={wrapperStyle}>
                {/* <label htmlFor="password" className="font-bold text-lg">Password:</label> */}
                <input type="password" 
                        value={signUpStudentForm.password} 
                        name="password" 
                        onChange={e => valueChange(e)}
                        className={inputStyle}
                        placeholder="Password"
                />
            </div> 
            <div className={wrapperStyle}>
                <button onClick={signUp}
                        className=" bg-sky-600 px-8 py-2 mx-4 mb-2 ml-0 rounded-sm w-full">
                        Sign Up
                </button>
            </div>
        </div>
    )
}

export default SignUp;