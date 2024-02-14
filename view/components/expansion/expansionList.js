import ExpansionListItem from "./expansionListItem";

const ExpansionList = ({expansions}) => {
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
                    expansionId={e.expansionId}
                    expansionName={e.expansionName}
                    expansionCode={e.expansionCode}
                    releasedDate={e.releasedDate}
                />
            ))}
        </tbody>
      </table>
    </>
  );
};

export default ExpansionList;