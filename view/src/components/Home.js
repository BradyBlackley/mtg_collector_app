const divStyle = {
    textAlign: "center",
    marginTop: "5px"
}

function Home(props) {
    return(
        <div className="home" style={divStyle}><h3>Welcome {props.username}</h3></div>
    )
}

export default Home;