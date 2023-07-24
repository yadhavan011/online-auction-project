import React from 'react';
//import Navbar from './Navbar';
import ResponsiveAppBar from './ResponsiveAppBar';
import List from './List';
//import Card from './Card';


//import Bidder from './Bidder'; 
//        <BidsDetails></BidsDetails><Bidder></Bidder>
        
import Seller from './Seller';
//import SellerHistory from './SellerHistory'; <SellerHistory></SellerHistory><SellerHistory></SellerHistory>
//import BidsDetails from './BidsDetails';
//import SellerHistory from './SellerHistory';

 
const HomePage = () => {
  return (
    <div>
        
        <ResponsiveAppBar></ResponsiveAppBar>
        <br></br>
        <h2>Ongoing Auctions Interested can Participate</h2>
        
        <br></br>
        <center>
        <List></List>
        </center>
        <br></br>
        <center>
        <Seller></Seller>
     </center>
       <br></br>
       
       <br></br>

      
    </div>
  );
};

export default HomePage;
