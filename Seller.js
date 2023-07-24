import React, { useState } from 'react';
import './Seller.css'; 

const Seller = () => {
  const [isCardClicked, setIsCardClicked] = useState(false);
  const [artName, setArtName] = useState('');
  const [bidAmount, setBidAmount] = useState('');

  const handleCardClick = () => {
    setIsCardClicked(true);
  };

  const handleNameChange = (event) => {
    setArtName(event.target.value);
  };

  const handleBidAmountChange = (event) => {
    setBidAmount(event.target.value);
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    const bidTime = new Date().toLocaleTimeString();
    console.log('Art Name:', artName);
    console.log('Bid Amount:', bidAmount);
    console.log('Bid Time:', bidTime);
    setIsCardClicked(false);
    setArtName('');
    setBidAmount('');
  };

  return (
    <div>
      {!isCardClicked ? (
        <div className="seller-card" onClick={handleCardClick}>
          <h3>Seller</h3>
        </div>
      ) : ( <center>
        <div className="seller-form">
          <h3>Enter Art Details</h3>
         
          <form onSubmit={handleSubmit}>
            <label htmlFor="art-name">Art Name:</label>
            <input
              type="text"
              id="art-name"
              value={artName}
              onChange={handleNameChange}
              required
            />
            <label htmlFor="bid-amount">Bid Amount:</label>
            <input
              type="text"
              id="bid-amount"
              value={bidAmount}
              onChange={handleBidAmountChange}
              required
              />
            <button type="submit">Submit</button>
          </form>
        </div></center>
      )}
    </div>
  );
};

export default Seller;


