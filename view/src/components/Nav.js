import { Link } from "react-router-dom";

const navStyle = {
    
}

const ulStyle = {
    listStyleType: "none",
    margin: "0",
    padding: "0",
    overflow: "hidden",
    backgroundColor: "#333333"
}

const liStyle = {
    float: "left",
    display: "block",
    padding: "16px",
}

const aStyle = {
    color: "white",
    textDecoration: "none"
}

function Nav() {
    return(
        <div className="nav" style={navStyle}>
            <ul style={ulStyle}>
                <li style={liStyle}><Link to="/home" style={aStyle}>Home</Link></li>
                <li style={liStyle}><Link to="/browse" style={aStyle}>Browse</Link></li>
                <li style={liStyle}><Link to="/myCollection" style={aStyle}>My Collection</Link></li>
                <li style={liStyle}><Link to="/statistics" style={aStyle}>Statistics</Link></li>
                <li style={liStyle}><Link to="/admin" style={aStyle}>Admin</Link></li>
            </ul>
        </div>
    )
}

export default Nav;