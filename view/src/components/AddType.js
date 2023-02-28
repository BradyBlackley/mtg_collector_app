import { useEffect } from "react";
import { getAllTypes } from "../services/type-services";
import { useState } from "react";

const liStyle = {
    listStyleType: "none"
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

    if (!types) return <div>Loading...</div>;
    
    return(
        <div className="add-type">
            <div id="myDropdown" className="dropdown-content">
                    <input 
                    type="text" 
                    placeholder="Search.." 
                    id="myInput" 
                    value={filter}
                    onChange={event => setFilter(event.target.value)}>
                    </input>
                <ul>
                    {types.filter(t => t.typeName.includes(filter) || filter === '')
                    .map(t => <li key={t.typeName} style={liStyle}>{t.typeName}</li>)}
                </ul>
            </div>
        </div>
    );
};

export default AddType;