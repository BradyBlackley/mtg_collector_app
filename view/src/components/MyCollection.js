const titleStyle = {
    textAlign: "center",
    marginTop: "5px"
}

const searchBarStyle = {
    textAlign: "center",
    marginTop: "5px"
}

function MyCollection() {
    return(
        <div className="myCollectionContainer">
            <div className="title" style={titleStyle}><h3>My Collection</h3></div>
            <div className="searchBar" style={searchBarStyle}>
                <input type="text" placeholder="Search my collection.."></input>
            </div>
        </div>
    )
}

export default MyCollection;