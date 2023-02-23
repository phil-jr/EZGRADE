"use client";

import { signOutStudent } from "@/services/StudentService";
import Link from "next/link";
import React, {FC, useEffect, useState} from "react";

const NavBar: FC = () => {

    const [studentSignedIn, setStudentSignedIn] = useState(false);

    useEffect(() => {
        const isStudentSignedIn = (typeof window !== 'undefined') && 
                                  localStorage.getItem("student-session")  != null;
        setStudentSignedIn(isStudentSignedIn);
    },[]);
    
    const signOutStudentCall = () => {
        console.log("HELLO");
        signOutStudent();
        (window as any).location = "/";
    }

    return (
        <div>
            <nav className="nav-bar-test">
                <ul className="flex">
                    { !studentSignedIn && 
                        <li className="nav-bar-li"><Link href="/">Home</Link></li>
                    }
                    { !studentSignedIn &&
                        <li className="nav-bar-li"><Link href="/signin">Sign In</Link></li>
                    }
                    { studentSignedIn &&
                        <li className="nav-bar-li"><Link href="/gradebook">My Gradebook</Link></li>
                    }
                    { studentSignedIn &&
                        <li className="nav-bar-li"><Link href="/settings">Settings</Link></li>
                    }
                    { studentSignedIn &&
                        <li className="nav-bar-li"><Link href="#" onClick={signOutStudentCall}>Sign Out</Link></li>
                    }
                    { !studentSignedIn &&
                        <li className="nav-bar-li"><Link href="/pricing">Pricing</Link></li>
                    }
                    { !studentSignedIn &&
                        <li className="nav-bar-li"><Link href="/about">About</Link></li>
                    }
                </ul>
            </nav>
        </div>
    )
}

export default NavBar;