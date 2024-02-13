import TypeList from "../type/typeList";
import styles from "./main.module.css";
import mockTypes from "../../testData/mockTypes.json"


const Main = ({headerText}) => {
    return (
        <div className={"row " + styles.main}>
            <TypeList types={mockTypes.types}/>
        </div>
    );
};

export default Main;