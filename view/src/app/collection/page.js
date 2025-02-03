import LibraryList from "../library/libraryList";
import AddLibrary from "../library/addLibrary";
import { revalidatePath } from 'next/cache';

export default async function Page(request) {
  revalidatePath('/collection', 'page');
  const url = "http://localhost:9191/api/libraries"; 
  const userId = "f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454";
  const init = {
      method: "GET",
      headers: {
          "Content-Type": "application/json",
          "Accept": "application/json"
      }
  };
    
  let res = await fetch(`${url}/allLibrariesByUser/${userId}`, init, { cache: 'no-store'});
  let libraryData = await res.json();
  
  return(
    <div>
      <div>TODO: list of cards</div>
      <div>TODO: make userId changeable when user logs in</div>
      <LibraryList librariesArr={libraryData.payload}/>
    </div>
  );
}