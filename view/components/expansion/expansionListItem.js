const ExpansionListItem = ({expansionId, expansionName, expansionCode, releasedDate}) => {
    return(
        <tr>
            <td>{expansionId}</td>
            <td>{expansionName}</td>
            <td>{expansionCode}</td>
            <td>{releasedDate}</td>
        </tr>
    );
};

export default ExpansionListItem;