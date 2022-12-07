const pStyle = {
    backgroundColor: "#99ff99",
    border: "solid",
    borderRadius: "10px",
    margin: "25px",
    padding: "25px"
}


function ResponseMessage (responseMessage) {
    return(
        <div>
            <p style={pStyle}>Success</p>
            {console.log(responseMessage)}
        </div>
    )
}

export default ResponseMessage;