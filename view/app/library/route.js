'use server'

export async function createLibrary() {
    const url = "http://localhost:9191/api/libraries"; 
    const userId = "f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454";
    const init = {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "Accept": "application/json"
        }
    };
      
    let res = await fetch(`${url}/addLibrary`, init)
    let data = await res.json()

    return data;
}