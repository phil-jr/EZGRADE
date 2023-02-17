"use client";

import Link from "next/link";
import React, {FC} from "react";

const NavBar: FC = () => {

    const studentSignedIn = (typeof window !== 'undefined') ?
                          localStorage.getItem("student-session") :
                          null;

    return (
        <>
            <nav className="nav-bar-test">
                <ul className="flex">
                    { !studentSignedIn && 
                        <li className="nav-bar-li"><Link href="/">Home</Link></li>
                    }
                    { !studentSignedIn &&
                        <li className="nav-bar-li"><Link href="/signin">Sign In</Link></li>
                    }
                    { !studentSignedIn &&
                        <li className="nav-bar-li"><Link href="/signup">Sign Up</Link></li>
                    }
                    { studentSignedIn &&
                        <li className="nav-bar-li"><Link href="/my-gradebook">My Gradebook</Link></li>
                    }
                    { studentSignedIn &&
                        <li className="nav-bar-li"><Link href="/settings">Settings</Link></li>
                    }
                    { studentSignedIn &&
                        <li className="nav-bar-li"><Link href="/signout">Sign Out</Link></li>
                    }
                    { !studentSignedIn &&
                        <li className="nav-bar-li"><Link href="/pricing">Pricing</Link></li>
                    }
                    { !studentSignedIn &&
                        <li className="nav-bar-li"><Link href="/about">About</Link></li>
                    }
                </ul>
            </nav>
        </>
    )
}

export default NavBar;