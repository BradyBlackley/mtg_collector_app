'use server';

export async function POST(request) {
    const url = "http://localhost:9191/api/libraries"; 
    const formData = await request.formData();
    const libraryName = formData.get('libraryName');
    const userId = formData.get('userId');

    const init = {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "Accept": "application/json"
        },
        body: {
            "libraryName": `${libraryName}`,
            "user": {
                "userId": `${userId}`
            }
        }
    };
      
    let res = await fetch(`${url}/addLibrary`, init)
    let data = await res.json()

    return Response.json({data});
}