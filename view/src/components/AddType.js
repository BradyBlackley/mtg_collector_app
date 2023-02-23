import { useCallback, useEffect } from "react";
import { getAllTypes } from "../services/type-services";
import { useState } from "react";

const liStyle = {
    listStyleType: "none"
}

function AddType() {

    const [types, setTypes] = useState([]);
    const [responseMessage, setResponseMessage] = useState();

    useEffect(() => {
        getAllTypes()
        .then(response => response.json())
        .then(response => setTypes(response.payload))
    }, []);

    // const filterFunction = useEffect (() => {
    //         var input, filter, ul, li, i, div, txtValue;
    //         input = document.getElementById("myInput");
    //         console.log(input);
    //         filter = input.value.toUpperCase();
    //         div = document.getElementById("myDropdown");
    //         ul = div.getElementsByTagName("ul");
    //         for (i = 0; i < ul.length; i++) {
    //           txtValue = ul[i].textContent || ul[i].innerText;
    //           if (txtValue.toUpperCase().indexOf(filter) > -1) {
    //             li[i].style.display = "";
    //           } else {
    //             li[i].style.display = "none";
    //           }
    //         }
    //     }, []);

    if (!types) return <div>Loading...</div>;
    
    return(
        <div className="add-type">
            {console.log(types)}
            {console.log(responseMessage)}
            <div id="myDropdown" className="dropdown-content">
                <ul>
                    <input type="text" placeholder="Search.." id="myInput" onKeyUp=""></input>
                    {types.map((type) => (
                        <li id={type.typeName} style={liStyle}>{type.typeName}</li>
                    ))}
                </ul>
            </div>
        </div>
    );
};

export default AddType;