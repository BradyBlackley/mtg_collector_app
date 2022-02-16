const statisticsStyle = {
    textAlign: "center",
    marginTop: "5px"
}

function Statistics() {
    return(
        <div className="statisticsContainer" >
            <div style={statisticsStyle}><h3>Statistics</h3></div>
            <div className="">Collection completion by expansion</div>
        </div>
    )
}

export default Statistics;