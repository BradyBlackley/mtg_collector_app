const ExpansionListItem = ({expansion}) => {
    return(
        <tr>
            <td>{expansion.expansionId}</td>
            <td>{expansion.expansionName}</td>
            <td>{expansion.expansionCode}</td>
            <td>{expansion.releasedDate}</td>
        </tr>
    );
};

export default ExpansionListItem;