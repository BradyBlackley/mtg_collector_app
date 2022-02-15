import React from 'react';
import { Link } from "react-router-dom";

const divStyle = {
    textAlign: "center",
    position: "fixed",
    bottom: "0",
    width: "100%",
    backgroundColor: "lightGrey",
    padding: "10px"
}

const aStyle = {
    textDecoration: "none",
    color: "black",
    "&:hover": {
        background: "#efefef"
      }
}


function Footer() {
    return (
        <div className="footer" style={divStyle}>
            <Link to="/about" style={aStyle}>About</Link> | <Link to="/support" style={aStyle}>Support</Link> | <Link to="/help" style={aStyle}>Help</Link>
        </div>
    );
}

export default Footer;