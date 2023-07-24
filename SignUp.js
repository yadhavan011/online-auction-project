import React from "react";
import * as Components from "./Components";
import './SignUp.css';
import { Link } from 'react-router-dom';


function SignUp() {
  const [signIn, toggle] = React.useState(true);
  return (
    <div name="a">
    <Components.Container>
      <center>
       
      <Components.SignUpContainer signinIn={signIn}>

        <Components.Form>
          <Components.Title>Create Account</Components.Title>
          <Components.Input type="text" placeholder="Name" />
          <Components.Input type="email" placeholder="Email" />
          <Components.Input type="password" placeholder="Password" />
          <Components.Button><Link to="/main">Sign Up</Link></Components.Button>
        </Components.Form>
      </Components.SignUpContainer>

      <Components.SignInContainer signinIn={signIn}>
        <Components.Form>
          <Components.Title>Sign in</Components.Title>
          <Components.Input type="email" placeholder="Email" />
          <Components.Input type="password" placeholder="Password" />
          <Components.Anchor href="#">Forgot your password?</Components.Anchor>
          <Components.Button><Link to="/main">Sign In</Link></Components.Button>
        </Components.Form>
      </Components.SignInContainer>

      <Components.OverlayContainer signinIn={signIn}>
        <Components.Overlay signinIn={signIn}>
          <Components.LeftOverlayPanel signinIn={signIn}>
            <Components.Title>GRIPPY</Components.Title>
            <Components.Paragraph>
              To start an Auction login with your personal info
            </Components.Paragraph>
            <Components.GhostButton onClick={() => toggle(true)}>
              Sign In
            </Components.GhostButton>
          </Components.LeftOverlayPanel>

          <Components.RightOverlayPanel signinIn={signIn}>
            <Components.Title>GRIPPY</Components.Title>
            <Components.Paragraph>
              Enter Your personal details and start Auction
            </Components.Paragraph>
            <Components.GhostButton onClick={() => toggle(false)}>
              Sign Up
            </Components.GhostButton>
          </Components.RightOverlayPanel>
        </Components.Overlay>
      </Components.OverlayContainer></center>
    </Components.Container></div>
  );
}

export default SignUp;