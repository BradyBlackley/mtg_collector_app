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

function AdminNav() {
    return(
        <div className="nav" style={navStyle}>
            <ul style={ulStyle}>
                <li style={liStyle}><Link to="/admin/addCard" style={aStyle}>Add Card</Link></li>
                <li style={liStyle}><Link to="/admin/addType" style={aStyle}>Add Type</Link></li>
                <li style={liStyle}><Link to="/admin/addExpansion" style={aStyle}>Add Expansion</Link></li>
                <li style={liStyle}><Link to="/admin/addKeyword" style={aStyle}>Add Keyword</Link></li>
            </ul>
        </div>
    )
}

export default AdminNav;