import CardList from "./cardList";

export default async function Page() {
  const url = "http://localhost:9191/api/cards"; 
  const init = {
      method: "GET",
      headers: {
          "Content-Type": "application/json",
          "Accept": "application/json"
      }
  };
    
  let res = await fetch(`${url}/allCards`, init)
  let data = await res.json()
  return(
    <div>
      <CardList cardsArr={data.payload}/>
    </div>
  );
}