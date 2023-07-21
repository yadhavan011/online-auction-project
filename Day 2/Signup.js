import React,{useState} from 'react'
// import './Signup.css'
import ReactDOM  from 'react-dom';
import { useNavigate } from 'react-router-dom';

function Signup() {
    const [formValues,setFormValues]=useState("");
    const [formErrors,setFormErrors]=useState({});
    const [isSubmit,setIsSubmit]=useState(false);
    const navigate= useNavigate();
    const handleChange=(event)=>{
        const{id,value}=event.target;
        setFormValues({...formValues,[id]:value});
        console.log(formValues);
    }
    
    const handleSubmit=(event)=>{
        event.preventDefault();
        setFormErrors(validate(formValues));
        if(formErrors.check === true){
            setIsSubmit(true);
            navigate("/");
        }
        else{
            setIsSubmit(false);
        }
    }
    const validate=(values)=>{
        const errors={};
        const reg=new RegExp("[0-9]")
        const preg=new RegExp("[A-Z][A-za-z0-9$_]+") 
        errors.check= true;
        if(!values.username)
        errors.username="Please Fill the column";
        else if(values.username.length<5){
            errors.check= false;
            errors.username="Username must have minimum 5 characters";
        }
        else if(reg.test(values.username)){
            errors.username="Username must contain only alphabets";
        }
        if(!values.email){
        errors.check= false;
        errors.email="Please Fill the email";
    }
    
    if(!values.password){
        errors.check= false;
        errors.password="Please Fill the password";
    }
    else if(values.password.length<5){
        errors.check= false;
        errors.password="Password is Weak";
    }
        return errors;
    }
const renderSignup = 
(
    <div className='form'>
        <form onSubmit={handleSubmit}> 
                <div className='input-container2'>
                    <label>Enter your username</label>
                    <input type="text" id='username' value={formValues.username}
                        onChange={handleChange} required/>
                </div>
                <p  style={{color:"red", fontWeight: "bold"}}>{formErrors.username}</p>

                <div className='input-container1'>
                    <label>Enter your email</label>
                    <input type="email" id='email' value={formValues.email}
                        onChange={handleChange} required/>
                </div>
                <p  style={{color:"red", fontWeight: "bold"}}>{formErrors.email}</p>

                <div className='input-container2'>
                    <label>Enter your password</label>
                    <input type="password" id='password' value={formValues.password}
                        onChange={handleChange} required/>
                </div>
                <p  style={{color:"red", fontWeight: "bold"}}>{formErrors.password}</p>

                <div className='button-container'>
                    <input type='submit'/>
                </div>
        </form>
    </div>
  );
  return(
    <div className="login">
    <div className="login-form">     
                <div className='title'>User Form</div>
        {isSubmit ? <div style={{color: "white"}}>User is successfully logged in</div> : renderSignup}
    </div>
  </div>
  );
}

export default Signup