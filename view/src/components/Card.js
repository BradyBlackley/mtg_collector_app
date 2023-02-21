import React from 'react';
import { useState } from "react";
import image from '../assets/card_images/zendikar_rising/znr-60-glasspool-mimic.jpg';

function Card(props) {

    const [imagePath, setImagePath] = useState("");

    const cardStyle = {
        border: "solid",
        borderRadius: "5px",
        padding: "0.25%",
        width: "244px",
        margin: "1%",
        backgroundColor: "grey"
    }

    const imageStyle = {
        width: "244px",
        height: "340px"
    }

    const buttonBarStyle = {
        textAlign: "center",
        display: "flex",
        justifyContent: "space-between",
        justifyContent: "space-around"
    }

    const addBtnStyle = {
        backgroundColor: "green",
        borderRadius: "5px"
    }

    const removeBtnStyle = {
        backgroundColor: "red",
        borderRadius: "5px"
    }

    return(
        <div className="card" style={cardStyle}>
            <>ZNR060</>
            <img src={image} style={imageStyle}/>
            <br/>
            <div className="button-bar" style={buttonBarStyle}>
            <button style={removeBtnStyle}>-</button>
            <>3</>
            <button style={addBtnStyle}>+</button>
            </div>
        </div>
    );
}

export default Card;