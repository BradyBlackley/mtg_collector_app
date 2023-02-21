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
                <Route path="/admin/addCard" element={<AddCard/>} />
                <Route path="/admin/addType" element={<AddType/>} />
                <Route path="/admin/addExpansion" element={<AddExpansion/>} />
                <Route path="/admin/addKeyword" element={<AddKeyword/>} />
            </Routes>
        </div>
    )
}

export default Admin;