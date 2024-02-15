const TypeListItem = ({types}) => {
  return(
    <tr>
      <td>{types.typeId}</td>
      <td>{types.typeName}</td>
    </tr>
  )
}

export default TypeListItem;