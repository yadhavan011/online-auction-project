
import React from 'react';
import ResponsiveAppBar from './ResponsiveAppBar';
import Slider from './Slider';
import List from './List';
import BidderDetails from './BidderDetails';
import './BidderHomePage.css';


function BidderHomePage() {
  return (
    <div>
        <ResponsiveAppBar></ResponsiveAppBar>
        <br></br>
        <br></br>
        
        
        
        <h2>RECENT AUCTIONS</h2>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <Slider></Slider>
        <br></br>
        <br></br>
        
        
        
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
       
        <center><h3>ONGOING AUCTIONS INTERESTED CAN PARTICIPATE</h3></center>
        <br></br>
        <br></br>
        
        
        <List></List>
        <BidderDetails></BidderDetails>
        
        
      
    </div>
  );
}

export default BidderHomePage;

