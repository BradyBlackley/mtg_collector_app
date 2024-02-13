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
                <th>expansion_id</th>
                <th>expansion_name</th>
                <th>expansion_code</th>
                <th>released_date</th>
            </tr>
        </thead>
        <tbody>
            {expansions.map((e) => (
                <ExpansionListItem 
                    key={e.expansion_id}
                    expansionId={e.expansion_id}
                    expansionName={e.expansion_name}
                    expansionCode={e.expansion_code}
                    releasedDate={e.released_date}
                />
            ))}
        </tbody>
      </table>
    </>
  );
};

export default ExpansionList;