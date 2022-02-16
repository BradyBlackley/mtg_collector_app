const searchBarStyle = {
    textAlign: "center",
    marginTop: "5px"
}

function Browse() {
    return(
        <div className="browse">
            <div className="searchBar" style={searchBarStyle}>
                <input type="text" placeholder="Search for a card.."></input>
            </div>
        </div>
    )
}

export default Browse;