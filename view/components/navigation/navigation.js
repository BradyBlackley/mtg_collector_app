import styles from "./navigation.module.css"

const Navigation = () => {
    return (
        <div className={"row " + styles.navigationBar}>
            <div className="btn-group " role="group">
                <button className="btn">Card Search</button>
                <button className="btn">Types</button>
                <button className="btn">Expansions</button>
                <button className="btn">Keywords</button>
                <button className="btn">Admin</button>
            </div>
        </div>
    );
};

export default Navigation;