import UserListItem from "../user/userListItem.js";

const LibraryListItem = ({ libraryId, libraryName, userId }) => {
    return(
        <tr>
            <td>{libraryId}</td>
            <td>{libraryName}</td>
            <td>{userId}</td>
        </tr>
    );
};

export default LibraryListItem;