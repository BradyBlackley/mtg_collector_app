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
            <th>type_id</th>
            <th>type_name</th>
          </tr>
        </thead>
        <tbody>
            {types.map((t) => (
              <TypeListItem key={t.type_id} typeId={t.type_id} typeName={t.type_name}/>
            ))}
        </tbody>
      </table>
    </>
  );
}

export default TypeList;