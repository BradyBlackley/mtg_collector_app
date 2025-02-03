'use client';

import React, { useState } from 'react';

async function postData(libraryName, userId) {
  const res = await fetch('http://localhost:9191/api/libraries/addLibrary', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify({libraryName, userId}),
    });
    return await res.json();
}


export default function AddLibrary({libraries, setLibraries}) {
//    const user = useContext(UserContext);
    const libraryId = 0;
    const [libraryName, setLibraryName] = useState("");
    const [userId, setUserId] = useState("f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454")

    const handleSubmit = async (event) => {
//        event.preventDefault();
        const data = await postData(libraryName, userId);
        const libCopy = libraries;
        setLibraries([...libraries, data.payload]);
    };

    return(
        <div className="row">
          <div className="row mb-2">
            <h5>Add Library</h5>
          </div>
        <form className="input-group" action={handleSubmit}>
          <div className="justify-content-md-center input-group-prepend">
            <button className="btn btn-outline-secondary" type="submit" id="button-addon1">Create</button>
          </div>
          <input 
            type="text" 
            value={libraryName} 
            onChange={(e) => setLibraryName(e.target.value)} 
            className="form-control" 
            placeholder="Library name"/>
        </form>
      </div>
    )
}