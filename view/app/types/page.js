import TypeList from "./typeList";

export default async function Page() {
  const url = "http://localhost:9191/api/types"; 
  const init = {
      method: "GET",
      headers: {
          "Content-Type": "application/json",
          "Accept": "application/json"
      }
  };
    
  let res = await fetch(`http://localhost:9191/api/types/allTypes`, init)
  let data = await res.json()

  return(
    <div>
      <TypeList typesArr={data.payload}/>
    </div>
  );
}