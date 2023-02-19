// "use client"

// import { Dispatch, SetStateAction, createContext, useContext, useState } from "react";

// interface IUser {
//   firstName: string;
//   lastName: string;
//   email: string;
//   address: string;
//   city: string;
//   state: string;
//   zipCode: string;
// }

// interface UserContextProps {
//   user: IUser;
//   setUser:  Dispatch<SetStateAction<IUser>>;
// }

// const UserContext = createContext<UserContextProps>({
//   user: {
//     firstName: "",
//     lastName: "",
//     email: "",
//     address: "",
//     city: "",
//     state: "",
//     zipCode: "",
//   },
//   setUser: () => null
// });


// export const UserContextProvider = ({children}: any) => {
//   const [user, setUser] = useState<IUser>({
//     firstName: "HELLO",
//     lastName: "",
//     email: "",
//     address: "",
//     city: "",
//     state: "",
//     zipCode: "",
//   })

//   return (
//     <UserContext.Provider value={{user, setUser}}>
//       {children}
//     </UserContext.Provider>
//   )
// }

// export const useUserContext = () => useContext(UserContext);