import React from 'react';
import ResponsiveAppBar from './ResponsiveAppBar';
import List from './List';
import AdminDetails from './AdminDetails';
import Seller from './Seller';


function AdminHomePage() {
  return (
    <div>
      
        <ResponsiveAppBar></ResponsiveAppBar>
        <List></List>
        <br></br>
        <br></br>
        <br></br>
        
        <AdminDetails></AdminDetails>
        <br></br>
        <br></br>
        
        <br></br>
        <br></br>
        <br></br>
        <br></br>
    </div>
  );
}

export default AdminHomePage;
