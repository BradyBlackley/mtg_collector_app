import dateFormatter from "/helpers/dateFormatter";

const ExpansionListItem = ({ expansionId, expansionName, expansionCode, releasedDate }) => {
    return(
        <>
            <td>{expansionId}</td>
            <td>{expansionName}</td>
            <td>{expansionCode}</td>
            <td>{dateFormatter.format(Date.parse(releasedDate))}</td>
        </>
    );
};

export default ExpansionListItem;