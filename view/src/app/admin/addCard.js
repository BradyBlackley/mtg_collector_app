'use client';

import React, { useState } from 'react';

async function postData(cardName, userId) {
  const res = await fetch('http://localhost:9191/api/libraries/addCard', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify({cardName, userId}),
    });
    return await res.json();
}


export default function AddCard({libraries, setLibraries}) {
    const [cardName, setCardName] = useState("");
    const [userId, setUserId] = useState("f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454")

    const handleSubmit = async (event) => {
        const data = await postData(cardName, userId);
        setLibraries([...libraries, data.payload]);
    };

    return(
        <div className="row">
          <div className="row mb-2">
            <h5>Add Card</h5>
          </div>
        <form className="input-group" action={handleSubmit}>
          <div className="justify-content-md-center input-group-prepend">
            <button className="btn btn-outline-secondary" type="submit" id="button-addon1">Create</button>
          </div>
          <input 
            type="text" 
            value={cardName} 
            onChange={(e) => setCardName(e.target.value)} 
            className="form-control" 
            placeholder="Card name"/>
        </form>
      </div>
    )
}