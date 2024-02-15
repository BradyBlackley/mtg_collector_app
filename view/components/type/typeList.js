import TypeListItem from "./typeListItem";

const TypeList = ({types}) => {
  return(
    <>
      <div className="row mb-2">
            <h5>Card Types</h5>
      </div>
      <table className="table table-hover">
        <thead>
          <tr>
            <th>type id</th>
            <th>type name</th>
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
    </>
  );
}

export default TypeList;