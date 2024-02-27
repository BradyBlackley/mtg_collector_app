export default async function handler(req, res) {
  const url = "http://localhost:9191/api/types"; 
  const init = {
      method: "GET",
      headers: {
          "Content-Type": "application/json",
          "Accept": "application/json"
      }
  };
    
  try {
    const response = await fetch(`${url}/allTypes`, init);
    const data = await response.json();
    res.status(200).json(data);
  } catch (error) {
    res.status(500).json(res.json.message);
  }
}