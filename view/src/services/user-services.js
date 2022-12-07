const url = "http://localhost:9191/api/users";

export async function addUser(user){
    const init = {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "Accept": "application/json"
        },
        body: JSON.stringify(user)
    };

    const response =  await fetch(`${url}/addUser`, init);
    if(response.status === 201){
        return response.json();
    }

    const {messages} = await response.json();
    return Promise.reject(messages);
}