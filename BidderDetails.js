import React, { useState } from 'react';
import './BidderDetails.css';



const BidderDetails = () => {
  const [showTable, setShowTable] = useState(false);
  const [tableData] = useState([
    {
      ID_no: 1,
      Name: 'John Doe',
      TypeOfAuction: 'Bidder',
      AuctionAmount: 1000,
    },
    {
      ID_no: 2,
      Name: 'Jane Smith',
      TypeOfAuction: 'Seller',
      AuctionAmount: 1500,
    },
    // Add more initial values here if needed
  ]);

  const handleCardClick = () => {
    setShowTable(true);
  };

  return (
    <div><center>
      {!showTable && (
        <div className="tablecard" onClick={handleCardClick}>
          <h3>BID RECORDS</h3>
        </div>
      )}

      <br></br>
      <br></br>
      <br></br>

      {showTable && (
        <div className="table-container">
          <table className="table">
            <thead><h2>BID RECORDS</h2>
            <center></center>
              <tr>
                <th>ID_no</th>
                <th>Name</th>
                <th>Type of Auction</th>
                <th>Auction Amount</th>
              </tr>
            </thead>
            <tbody>
              {tableData.map((row, index) => (
                <tr key={index}>
                  <td>{row.ID_no}</td>
                  <td>{row.Name}</td>
                  <td>{row.TypeOfAuction}</td>
                  <td>{row.AuctionAmount}</td>
                </tr>
              ))}
            </tbody>
          </table>
          
        </div>
      )}</center>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
    </div>
  );

};

export default BidderDetails;



