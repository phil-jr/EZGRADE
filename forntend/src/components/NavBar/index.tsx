import React, { useState } from "react";
import './index.css'

const NavBar = () => {

    const [testState, setTestState] = useState("A little biy");

    return (
        <>
            <p>{testState}</p>
        </>
    )
}

export default NavBar;