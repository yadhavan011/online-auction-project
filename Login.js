import React from "react";
import "./Login.css";

class SignIn extends React.Component {
  render() {
    return (
      <div className="container">
        <div className="left-column" style={{ backgroundColor: "#f27157" }}>
          {/* Sign Up component */}
          <label>Email Address</label>
          <input type="email" placeholder="Email Address" className="input" />
          <label>Password</label>
          <input type="password" placeholder="Password" className="input" />
          <button className="sign-in-button">Sign In</button>
        </div>
        <div className="right-column">
          <h1 className="header">GRIPPY</h1>
          <p className="paragraph">
            Enter your name, email address, and password to start your Auction
          </p>
          <button className="sign-in-button">Sign Up</button>
        </div>
      </div>
    );
  }
}

export default SignIn;