import AdminNav from "./AdminNav";
import { BrowserRouter as Router, Routes, Route} from "react-router-dom";
import AddCard from "./AddCard";
import AddType from "./AddType";
import AddExpansion from "./AddExpansion";
import AddKeyword from "./AddKeyword";

const searchBarStyle = {
    textAlign: "center",
    marginTop: "5px"
}

function Admin() {

    return(
        <div className="admin">
            <AdminNav />
            <Routes>
                <Route path="/addCard" element={<AddCard/>} />
                <Route path="/addType" element={<AddType/>} />
                <Route path="/addExpansion" element={<AddExpansion/>} />
                <Route path="/addKeyword" element={<AddKeyword/>} />
            </Routes>
        </div>
    )
}

export default Admin;