import React from 'react';
import { useState } from "react";

const messageStyle = {
    backgroundColor: "#99ff99",
    border: "solid",
    borderRadius: "10px",
    margin: "25px",
    padding: "25px"
}


function ResponseMessage ({responseMessage}) {

    return(
        <div>
            <p style={messageStyle}>{responseMessage?.messages}</p>
        </div>
    )
}

export default ResponseMessage;