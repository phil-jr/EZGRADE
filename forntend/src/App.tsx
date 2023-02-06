import React from 'react';
import logo from './logo.svg';
import './App.css';
import NavBar from './components/NavBar';
import SignUp from './components/SignUp';

function App() {
  return (
    <div className="App">
      <NavBar/>
      <SignUp/>
    </div>
  );
}

export default App;
