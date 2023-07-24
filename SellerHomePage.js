
import React from 'react';
import './SellerHomePage.css';
import ResponsiveAppBar from './ResponsiveAppBar';
import { Link } from 'react-router-dom';
import Management from './components/Management';
//import List from './List';




function SellerHomePage() {
  return (
    <div>
        <ResponsiveAppBar></ResponsiveAppBar>
        <br></br>
        <button className="sell button"> <Link to="/sp">SELL A PRODUCT</Link> </button><br></br>
        <button className="delete button"> <Link to="/DeleteRecord">DELETE PRODUCT</Link> </button>

        <br></br>
        <br></br>
        <br></br>
        <br></br>

        <Management></Management>
        
        
      
    </div>
  );
}

export default SellerHomePage;

