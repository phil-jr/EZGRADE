"use client"

import { SignInForm } from "@/models/SignInForm";
import { signInStudent } from "@/services/StudentService";
import { FC, useState } from "react"

const SignIn: FC = () => {

    const inputStyle = "border border-slate-400 block rounded-sm w-full h-12 p-2";
    const wrapperStyle = "mx-auto block w-10/12 my-2 max-w-lg";

    const [signInStudentForm, setSignInStudentForm] = useState<SignInForm>({
        email: "",
        password: ""
    })

    const valueChange = (e: any) => {
        setSignInStudentForm({
          ...signInStudentForm,
          [e.target.name]: e.target.value
        });
    }

    const signIn = async () => {
        let res = await signInStudent(signInStudentForm);
        const { sessionId } = res.data;
        (typeof window !== 'undefined') && localStorage.setItem("student-session", sessionId);
        console.log(res.data);
        (window as any).location = "/";
    }

    return (
        <div className="flex flex-col sm:w-3/5 max-w-xl w-full mr-auto ml-auto">
            <h1 className="mx-auto p-4 text-2xl font-bold">Log into EzGrade</h1>
            <div className={wrapperStyle}>
                {/* <label htmlFor="email" className="font-bold text-lg">Email:</label> */}
                <input type="email" 
                        value={signInStudentForm.email} 
                        name="email" 
                        onChange={e => valueChange(e)}
                        className={inputStyle}
                        placeholder="Email"
                />
            </div>
            <div className={wrapperStyle}>
                {/* <label htmlFor="password" className="font-bold text-lg">Password:</label> */}
                <input type="password" 
                        value={signInStudentForm.password} 
                        name="password" 
                        onChange={e => valueChange(e)}
                        className={inputStyle}
                        placeholder="Password"
                />
            </div> 
            <div className={wrapperStyle}>
                <button onClick={signIn}
                        className=" bg-sky-600 px-8 py-2 mx-4 mb-2 ml-0 rounded-sm w-full">
                        Sign In
                </button>
            </div>
        </div>
    )
}

export default SignIn;