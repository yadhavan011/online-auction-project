import React from "react";
import './MainPage.css';
import { Link } from 'react-router-dom';
import SliderImage from './SliderImage';

function MainPage() {
  return (
    <div className="A">
      <SliderImage />
      <div className="main-container">
        <div className="button-container">
          <button className="admin-button"><Link to="/ahp">ADMIN</Link></button>
          <button className="seller-button"><Link to="/shp">SELLER</Link></button>
          <button className="bidder-button"> <Link to="/bhp">BIDDER</Link> </button>
        </div>

        <br />
        <br />
        <br />
        <br />
        <br />

        
      </div>
    </div>
  );
}

export default MainPage;
