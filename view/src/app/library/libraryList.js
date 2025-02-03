'use client';

import { useRef, useState, useContext } from 'react';
import LibraryListItem from "./libraryListItem";
import AddLibrary from './addLibrary';
import UserContext from '../context';

export default function LibraryList({librariesArr}) {
  
  const [libraries, setLibraries] = useState(librariesArr);
  const { username } = useContext(UserContext);
  const inputEl = useRef(null);
  const onButtonClick = () => {
    inputEl.current.focus();
  }
  
  return(
    <>
      <div className="row mb-2">
            <h5>{`${username}'s Libraries`}</h5>
      </div>
      <div className="row">
        <div className="input-group">
          <div className="justify-content-md-center input-group-prepend">
            <button className="btn btn-outline-secondary" type="button" id="button-addon1" onClick={onButtonClick}>Search</button>
          </div>
          <input ref={inputEl} type="text" className="form-control" placeholder="Library name"/>
        </div>
      </div>
      <table className="table table-hover">
        <thead>
            <tr>
              <td>Library Id</td>
              <td>Library Name</td>
              <td>User Id</td>
            </tr>
        </thead>
        <tbody>
            {libraries.map((l) => (
                <LibraryListItem 
                    key={l.libraryId} 
                    libraryId={l.libraryId} 
                    libraryName={l.libraryName} 
                    userId={l.userId} 
                />
            ))}
        </tbody>
      </table>
      <AddLibrary libraries={libraries} setLibraries={setLibraries}/>
    </>
  );
};