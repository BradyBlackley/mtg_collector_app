const divStyle = {
    textAlign: "center",
    marginTop: "5px"
}

function Home(props) {
    return(
        <div className="home" style={divStyle}>Welcome {props.username} </div>
    )
}

export default Home;