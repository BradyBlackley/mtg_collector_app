'use client';

import { useRef, useState, useContext } from 'react';
import LibraryListItem from "./libraryListItem";
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
      <div class="row">
        <div class="input-group">
          <div className="justify-content-md-center input-group-prepend">
            <button className="btn btn-outline-secondary" type="button" id="button-addon1" onClick={onButtonClick}>Search</button>
          </div>
          <input ref={inputEl} type="text" class="form-control" placeholder="Library name"/>
        </div>
      </div>
      <table className="table table-hover">
        <thead>
            <tr>
              <td>Library Id</td>
              <td>Library Name</td>
              <td>User</td>
            </tr>
        </thead>
        <tbody>
            {libraries.map((l) => (
                <LibraryListItem 
                    key={l.libraryId} 
                    libraryId={l.libraryId} 
                    libraryName={l.libraryName} 
                    user={l.user} 
                />
            ))}
        </tbody>
      </table>
    </>
  );
};