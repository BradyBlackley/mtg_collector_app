import CardList from "./cardList";
import { revalidatePath } from 'next/cache';

export default async function Page(request) {
  const url = "http://localhost:9191/api/cards"; 
  revalidatePath('/card-search', 'page');
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