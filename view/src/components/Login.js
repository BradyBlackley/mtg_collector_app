import { useState } from "react";
import { Link, useHistory } from "react-router-dom";

const divStyle = {
    padding: "25px",
    margin: "25px",
    color: "black",
    textAlign: "center"
}

function Login() {

    const [name, setName] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = async (event) => {
        event.preventDefault();
        //TODO
    };

    return(
        <div className="login" style={divStyle}>
            <h3>Login</h3>
            <form onSubmit={handleSubmit} className="form-login">
                <div>
                    <label>Username</label>
                    <br/>
                    <input type="text" onChange={(event) => setName(event.target.value)} />
                </div>
                <div>
                    <label>Password</label>
                    <br/>
                    <input type="password" onChange={(event) => setPassword(event.target.value)} />
                </div>
                <br/>
                <div className="buttons">
                    <button type="submit">Login</button>
                </div>
            </form>
            <br/>
            <h6>Need an account? <Link to="/register">Register</Link></h6>
        </div>
    )
}

export default Login;