const pStyle = {
    backgroundColor: "#99ff99",
    border: "solid",
    borderRadius: "10px",
    margin: "25px",
    padding: "25px"
}


function ResponseMessage ({response}) {
    return(
        <div>
            <p style={pStyle}></p>
        </div>
    )
}

export default ResponseMessage;