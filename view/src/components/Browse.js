const searchBarStyle = {
    textAlign: "center",
    marginTop: "5px"
}

function Browse() {
    return(
        <div className="browse">
            <div className="searchBar" style={searchBarStyle}>
                <input type="text" placeholder="Search all cards.."></input>
            </div>
            <div className="expansionSelection">
                Search By Expansion
                {/* TODO: get all request expansions, for each item create a clickable link */}
            </div>
        </div>
    )
}

export default Browse;