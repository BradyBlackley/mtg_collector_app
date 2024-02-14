import TypeList from "../type/typeList";
import styles from "./main.module.css";
import mockTypes from "../../testData/mockTypes.json";
import mockExpansions from "../../testData/mockExpansions.json";
import ExpansionList from "../expansion/expansionList";


const Main = ({headerText}) => {
    return (
        <div className={"row " + styles.main}>
            <TypeList types={mockTypes.types}/>
            {/* <ExpansionList expansions={mockExpansions.expansions}/> */}
        </div>
    );
};

export default Main;