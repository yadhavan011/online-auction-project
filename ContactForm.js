import React, { useState } from "react";
import './ContactForm.css';

function ContactForm() {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [message, setMessage] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    // Add your logic here to handle form submission, e.g., sending the form data to a server.
    // For this example, we will just log the form data to the console.
    console.log('Form Data:', { name, email, message });
  };

  return (
    <form className="contact-form" onSubmit={handleSubmit}>
      <h2>Contact Us</h2>
      <div className="form-group">
        <label htmlFor="name">Name:</label>
        <input
          type="text"
          id="name"
          value={name}
          onChange={(e) => setName(e.target.value)}
          required
        />
      </div>
      <div className="form-group">
        <label htmlFor="email">Email:</label>
        <input
          type="email"
          id="email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          required
        />
      </div>
      <div className="form-group">
        <label htmlFor="message">Message:</label>
        <textarea
          id="message"
          value={message}
          onChange={(e) => setMessage(e.target.value)}
          required
        />
      </div>
      <button type="submit">Submit</button>
    </form>
  );
}

export default ContactForm;
