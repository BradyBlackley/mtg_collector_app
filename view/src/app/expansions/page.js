import ExpansionList from "./expansionList";

export default async function Page() {
  const url = "http://localhost:9191/api/expansions"; 
  const init = {
      method: "GET",
      headers: {
          "Content-Type": "application/json",
          "Accept": "application/json"
      }
  };
    
  let res = await fetch(`${url}/allExpansions`, init)
  let data = await res.json()

  return(
    <div>
      <ExpansionList expansionsArr={data.payload}/>
    </div>
  );
}