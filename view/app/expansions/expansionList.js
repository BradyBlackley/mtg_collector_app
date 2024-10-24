'use client';

import { useRef, useState } from 'react';
import ExpansionListItem from "./expansionListItem";

export default function ExpansionList({expansionsArr}) {
  const [expansions, setExpansions] = useState(expansionsArr);
  const inputEl = useRef(null);
  const onButtonClick = () => {
    inputEl.current.focus();
  }
  
  return(
    <>
      <div className="row mb-2">
            <h5>Card Expansions</h5>
      </div>
      <div className="row mb-2 mt-2 justify-content-md-center">
        <input ref={inputEl} type="text" />
        <button className="btn btn-primary" onClick={onButtonClick}>Search</button>
      </div>
      <table className="table table-hover">
        <thead>
            <tr>
                <th>expansion id</th>
                <th>expansion name</th>
                <th>expansion code</th>
                <th>released date</th>
            </tr>
        </thead>
        <tbody>
            {expansions.map((e) => (
                <ExpansionListItem 
                    key={e.expansionId}
                    {...e}
                />
            ))}
        </tbody>
      </table>
    </>
  );
};