import { useEffect } from "react";
import { getAllTypes } from "../services/type-services";
import { useState } from "react";
import searchIcon from "../assets/icons/icons8-search-more-30.png";
import editIcon from "../assets/icons/icons8-edit-row-26.png";
import deleteIcon from "../assets/icons/icons8-trash-can-layout-for-a-indication-to-throw-trash-24.png";

const inputBarStyle = {
    marginLeft: "25px",
    border: "solid", 
    width: "fit-content",
    marginTop: "10px",
    borderRadius: "5px",
    padding: "5px",
    backgroundColor: "#d9d9d9",
    display: "flex"
}

const inputStyle = {
    height: "36px",
    width: "348px"
}

const liStyle = {
    listStyleType: "none"
}

const liDivStyle = {
    border: "solid",
    borderRadius: "5px",
    width: "400px",
    margin: "1px",
    padding:"5px",
    display: "flex",
    justifyContent: "space-between",
    backgroundColor: "#e6e6e6"
}

const addBtnStyle = {
    backgroundColor: "green",
    borderRadius: "5px",
    height: "40px",
    width: "40px",
    marginLeft: "5px"
}

const buttonGroupStyle = {
    alignSelf: "center"
}

const editBtnStyle = {
    backgroundColor: "#abbdff",
    borderRadius: "5px",
    marginRight: "5px"
}

const deleteBtnStyle = {
    backgroundColor: "#ff4d4d",
    borderRadius: "5px"
}

const searchIconStyle = {
    margin: "2px"
}

function AddType() {

    const [types, setTypes] = useState([]);
    const [responseMessage, setResponseMessage] = useState();
    const [filter, setFilter] = useState('');

    useEffect(() => {
        getAllTypes()
        .then(response => response.json())
        .then(response => setTypes(response.payload))
    }, []);

    if (types.length <= 0) return <div>Loading...</div>;
    
    return(
        <div className="add-type">
            <div id="myDropdown" className="dropdown-content">
                    <div style={inputBarStyle}>
                        <img src={searchIcon} style={searchIconStyle} width="35px" height="35px" alt="search icon"/>
                        <input 
                        type="text" 
                        placeholder="Type" 
                        id="myInput" 
                        value={filter}
                        onChange={event => setFilter(event.target.value)}
                        style={inputStyle}
                        >
                        </input>
                        <button style={addBtnStyle}>+</button>
                    </div>
                <ul>
                    {types.filter(t => t.typeName.includes(filter) || filter === '')
                    .map(t => 
                    <div style={liDivStyle}>
                        <li key={t.typeName} style={liStyle}>{t.typeName}</li>
                        <div style={buttonGroupStyle}>
                            <button style={editBtnStyle}><img src={editIcon} width="26px" height="26px" alt="edit icon"></img></button>
                            <button style={deleteBtnStyle}><img src={deleteIcon} width="26px" height="26px" alt="delete icon"></img></button>
                        </div>
                    </div>)}
                </ul>
            </div>
        </div>
    );
};

export default AddType;