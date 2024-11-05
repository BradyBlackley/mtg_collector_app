import UserListItem from "../user/userListItem.js";

const LibraryListItem = ({ libraryId, libraryName, user }) => {
    return(
        <tr>
            <td>{libraryId}</td>
            <td>{libraryName}</td>
            <td><UserListItem key={user.userId} {...user}/></td>
        </tr>
    );
};

export default LibraryListItem;