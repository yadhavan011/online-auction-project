import React, { useState } from 'react';
import './BidderForm.css';

const BidderForm = () => {
  const [bidderName, setBidderName] = useState('');
  const [productName, setProductName] = useState('');
  const [bidPrice, setBidPrice] = useState('');

  const handleBidderNameChange = (event) => {
    setBidderName(event.target.value);
  };

  const handleProductNameChange = (event) => {
    setProductName(event.target.value);
  };

  const handleBidPriceChange = (event) => {
    setBidPrice(event.target.value);
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    // Handle form submission logic here
    console.log('Bidder Name:', bidderName);
    console.log('Product Name:', productName);
    console.log('Bid Price:', bidPrice);
    // Reset form fields
    setBidderName('');
    setProductName('');
    setBidPrice('');
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label htmlFor="bidderName">Bidder Name:</label>
        <input
          type="text"
          id="bidderName"
          value={bidderName}
          onChange={handleBidderNameChange}
          required
        />
      </div>
      <div>
        <label htmlFor="productName">Product Name:</label>
        <input
          type="text"
          id="productName"
          value={productName}
          onChange={handleProductNameChange}
          required
        />
      </div>
      <div>
        <label htmlFor="bidPrice">Bid Price:</label>
        <input
          type="number"
          id="bidPrice"
          value={bidPrice}
          onChange={handleBidPriceChange}
          required
        />
      </div>
      <button type="submit">Submit</button>
    </form>
  );
};

export default BidderForm;
