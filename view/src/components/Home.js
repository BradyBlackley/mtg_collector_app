const homeStyle = {

}

const homeTitleStyle = {
    textAlign: "center",
    marginTop: "5px"
}

function Home(props) {
    return(
        <div className="homeContainer" style={homeStyle}>
            <div className="homeTitle" style={homeTitleStyle}><h3>Welcome {props.username}</h3></div>
            <div className="cardCount">You own [ ] total cards</div>
        </div>
    )
}

export default Home;