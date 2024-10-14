'use client';

import { useState } from 'react';
import ExpansionListItem from "./expansionListItem";

export default function ExpansionList({expansionsArr}) {
  const [expansions, setExpansions] = useState(expansionsArr);
  
  return(
    <>
      <div className="row mb-2">
            <h5>Card Expansions</h5>
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