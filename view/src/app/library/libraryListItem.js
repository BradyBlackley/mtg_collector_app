"use client"

async function deleteLibrary(libraryName, userId) {
    const res = await fetch('http://localhost:9191/api/libraries/deleteLibrary', {
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({libraryName, userId}),
      });
      return await res.json();
  }

const LibraryListItem = ({ libraryId, libraryName, userId, libraries, setLibraries }) => {
    
    const handleClick = async () => {
        await deleteLibrary(libraryName, userId);
        setLibraries(libraries.filter(library => library.libraryName !== libraryName))
    };

    return(
        <tr>
            <td>{libraryId}</td>
            <td>{libraryName}</td>
            <td>{userId}</td>
            <td><button onClick={handleClick}>Delete</button></td>
        </tr>
    );
};

export default LibraryListItem;