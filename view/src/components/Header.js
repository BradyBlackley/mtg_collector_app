const divStyle= {
    backgroundColor: "DodgerBlue",
    textAlign: "center",
    padding: "16px"
}


function Header() {
    return (
        <div className="header" style={divStyle}>
            Magic the Gathering Collector's App
        </div>
    );
}

export default Header;