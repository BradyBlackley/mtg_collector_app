'use client';

import createLibrary from "./route";
import { useRef, useState, useContext } from 'react';
import UserContext from "../context";

export default function AddLibrary() {
    const user = useContext(UserContext);
    const [library, setLibrary] = useState({libraryName: "", user: user});
    const inputEl = useRef(null);

    const handleSubmit = () => {
        const fetchData = async () => {
          const response = await fetch('app/library/addLibrary')
        }
    }

    return(
        <div className="row">
          <div className="row mb-2">
            <h5>Add Library</h5>
          </div>
        <form className="input-group" onSubmit={handleSubmit}>
          <div className="justify-content-md-center input-group-prepend">
            <button className="btn btn-outline-secondary" type="submit" id="button-addon1">Create</button>
          </div>
          <input ref={inputEl} type="text" className="form-control" placeholder="Library name"/>
        </form>
      </div>
    )
}