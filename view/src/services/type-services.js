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

export async function addType(type){
    const init = {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "Accept": "application/json"
        },
        body: JSON.stringify(type)
    };

    const response =  await fetch(`${url}/addType`, init);
    if(response.status === 200){
        return response;
    }

    const {messages} = await response.json();
    return Promise.reject(messages);
}