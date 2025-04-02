'use client';

import React, { useState } from 'react';

async function postData(typeName) {
  const res = await fetch('http://localhost:9191/api/types/addType', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify({typeName}),
    });
    return await res.json();
}


export default function AddType({types, setTypes}) {
    const [typeName, setTypeName] = useState("");

    const handleSubmit = async (event) => {
        const data = await postData(typeName);
        setTypes([...types, data.payload]);
    };

    return(
        <div className="row">
          <div className="row mb-2">
            <h5>Add Type</h5>
          </div>
        <form className="input-group" action={handleSubmit}>
          <div className="justify-content-md-center input-group-prepend">
            <button className="btn btn-outline-secondary" type="submit" id="button-addon1">Create</button>
          </div>
          <input 
            type="text" 
            value={typeName} 
            onChange={(e) => setTypeName(e.target.value)} 
            className="form-control" 
            placeholder="Type name"/>
        </form>
      </div>
    )
}