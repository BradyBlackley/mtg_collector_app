const url = "http://localhost:9191/api/types";

export async function getAllTypes(){
    const init = {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
            "Accept": "application/json"
        }
    };

    const response =  await fetch(`${url}/allTypes`, init);
    if(response.status === 200){
        return response;
    }

    const {messages} = await response.json();
    return Promise.reject(messages);
}