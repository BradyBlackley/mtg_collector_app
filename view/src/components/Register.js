import React from 'react';
import { useState } from "react";
import { Link } from "react-router-dom";
import { addUser } from '../services/user-services';
import Errors from './Errors';

const divStyle = {
    padding: "25px",
    margin: "25px",
    color: "black",
    textAlign: "center"
}


function Register() {
    
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPass, setConfirmPass] = useState("");
    const [errors, setErrors] = useState([]);

    const onSubmit = evt => {
        if(password !== confirmPass) {
            evt.preventDefault();
             setErrors(["Passwords do not match"]);
        } else {
            evt.preventDefault();
                evt.preventDefault();
                
                const user = {
                    "username": username,
                    "password": password
                };
                
                addUser(user)
                .then()
                .catch(err => setErrors);
        }
    };

    return (
        <form onSubmit={onSubmit}>
            <div className="background-card">
                <div className="register" style={divStyle}>
                    <div>
                        <h3>Register</h3>
                    </div>
                    <div className="registerUserArea">
                        <label htmlFor="username">Username</label>
                        <br></br>
                        <input type="text" id="username" name="username" 
                            value={username} onChange={evt => setUsername(evt.target.value)} />
                    </div>
                    <div className="registerPassArea">
                        <label htmlFor="password">Password</label>
                        <br></br>
                        <input type="password" id="password" name="password" 
                            value={password} onChange={evt => setPassword(evt.target.value)} />
                    </div>
                    <div className="registerConfirmPassArea">
                        <label htmlFor="confirmPass"> Confirm Password</label>
                        <br></br>
                        <input type="password" id="confirmPass" name="confirmPass" 
                            value={confirmPass} onChange={evt => setConfirmPass(evt.target.value)} />
                    </div>
                    <br/>
                    <div className="submitBtnArea">
                        <button type="submit" className="submitBtn">Register</button>
                        <div>
                            <br/>
                            <h6>Already have an account? <Link to="/login">Login</Link></h6>
                        </div>
                    </div>
                    { <Errors errors={errors} /> }
                </div>
            </div>
        </form>
    );
}

export default Register;