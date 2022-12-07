const pStyle = {
    backgroundColor: "#ffb3b3",
    borderRadius: "5px",
    border: "solid",
    padding: "25px",
    margin: "25px",
    textAlign: "center"
}


const Errors = ({ errors }) => {
    return (<>{errors && errors.length > 0 && <div className="alert alert-danger">
            {errors.map(e => <p key={e} style={pStyle}>{e}</p>)}
    </div>}</>
    );
};

export default Errors;