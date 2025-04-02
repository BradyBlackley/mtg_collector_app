import TypeList from "./typeList";
import { revalidatePath } from 'next/cache';

export default async function Page() {
  const url = "http://localhost:9191/api/types"; 
  revalidatePath('/types', 'page');
  const init = {
      method: "GET",
      headers: {
          "Content-Type": "application/json",
          "Accept": "application/json"
      }
  };
    
  let res = await fetch(`${url}/allTypes`, init)
  let data = await res.json()

  return(
    <div>
      <TypeList typesArr={data.payload}/>
    </div>
  );
}