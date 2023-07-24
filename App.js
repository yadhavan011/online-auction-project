import React from "react";
// import A from "./A";
import LoginForm from "./Login";
import RegistrationForm from "./SignUp";
import MainPage from "./MainPage";
import './App.css';
import AdminHomePage from './AdminHomePage';
import SellerHomePage from './SellerHomePage';
import BidderHomePage from './BidderHomePage';
import Sellproduct from './Sellproduct';


import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
const App = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<RegistrationForm />} />
        <Route path="/" element={<LoginForm />} />
        <Route path="/main" element={<MainPage />} />
        <Route path="/ahp" element={<AdminHomePage />} />
        <Route path="/shp" element={<SellerHomePage />} />
        <Route path="/bhp" element={<BidderHomePage />} />
        <Route path="/sp" element={<Sellproduct/>} />
        
      </Routes>
    </Router>
  );
};

export default App;