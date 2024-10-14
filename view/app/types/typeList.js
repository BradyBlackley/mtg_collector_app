'use client';

import { useEffect, useState, useRef } from 'react';
import TypeListItem from "./typeListItem";

export default function TypeList({typesArr}) {
  const [types, setTypes] = useState(typesArr);
  const inputEl = useRef(null);
  const onButtonClick = () => {
    inputEl.current.focus();
  }

  return(
    <div className="container">
      <div className="row justify-content-md-center">
            <h5>Card Types</h5>
      </div>
      <div className="row mb-2 mt-2 justify-content-md-center">
        <input ref={inputEl} type="text" />
        <button className="btn btn-primary" onClick={onButtonClick}>Search</button>
      </div>
      <table className="table table-hover">
        <thead>
          <tr>
            <th>Type Id</th>
            <th>Type Name</th>
          </tr>
        </thead>
        <tbody>
            {types.map((t) => (
              <TypeListItem 
                key={t.typeId} 
                {...t}
              />
            ))}
        </tbody>
      </table>
    </div>
  );
}