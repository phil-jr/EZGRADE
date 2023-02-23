"use client"

import { FC, useState } from "react";
import SignUp from "./SignUp";
import SignIn from "./SignIn";

const SignPage: FC = () => {

  const [signUp, setSignUp] = useState(true);

  return (
    <>
      <ul className="flex justify-center  sm:w-3/5 max-w-xl w-full mr-auto ml-auto">
        <li onClick={() => setSignUp(true)} className={signUp? "active-sign" : "inactive-sign"}>Sign Up</li>
        <li onClick={() => setSignUp(false)} className={!signUp? "active-sign" : "inactive-sign"}>Sign In</li>
      </ul>
      {signUp &&  <SignUp />}
      {!signUp && <SignIn />}
    </>
  );
}

export default SignPage;