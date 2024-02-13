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
                <tr key={t.type_id}>
                    <td>{t.type_id}</td>
                    <td>{t.type_name}</td>
                </tr>
            ))}
        </tbody>
      </table>
    </>
  );
}

export default TypeList;