"use client";

import Link from "next/link";
import React, {FC} from "react";

const NavBar: FC = () => {

    return (
        <>
            <nav className="bg-amber-300 drop-shadow">
                <ul className="flex">
                    <li className="p-4 bg-amber-300 cursor-pointer hover:bg-amber-500"><Link href="/">Home</Link></li>
                    <li className="p-4 bg-amber-300 cursor-pointer hover:bg-amber-500"><Link href="/login">Login</Link></li>
                    <li className="p-4 bg-amber-300 cursor-pointer hover:bg-amber-500">Pricing</li>
                    <li className="p-4 bg-amber-300 cursor-pointer hover:bg-amber-500">About</li>
                </ul>
            </nav>
        </>
    )
}

export default NavBar;