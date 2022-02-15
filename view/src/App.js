import Header from "./components/Header";
import Nav from "./components/Nav";
import Footer from "./components/Footer";
import Home from "./components/Home";
import Browse from "./components/Browse";
import MyCollection from "./components/MyCollection";
import Statistics from "./components/Statistics";
import Login from "./components/Login";
import Register from "./components/Register";
import About from "./components/About";
import Support from "./components/Support";
import Help from "./components/Help";
import { BrowserRouter as Router, Routes, Route} from "react-router-dom";
import { useState } from "react";
import background from "./assets/site-images/mana-symbols.jpg";

const backgroundPanelStyle = {
  backgroundImage : `url(${background})`,
  backgroundRepeat: "no-repeat",
  width: "auto",
  height: "564px",
  marginTop: "4%",
  backgroundPosition: "center",
  opacity: "0.1",
  position: "relative"
}

const displayPanelStyle = {
  position: "absolute"
}

function App() {
  const [username, setUsername] = useState(null);
  const [userId, setUserId] = useState(null);

  return (
    <div className="App">
      <Header></Header>
      <Router>
      <Nav/>
        <div className="backgroundPanel" style={backgroundPanelStyle}></div>
        <div className="displayPanel" style={displayPanelStyle}>
          <Routes>
              <Route path="/home" element={<Home />} />
              <Route path="/browse" element={<Browse />} />
              <Route path="/myCollection" element={<MyCollection />} />
              <Route path="/statistics" element={<Statistics />} />
              <Route path="/login" element={<Login />} />
              <Route path="/register" element={<Register />} />
              <Route path="/about" element={<About />} />
              <Route path="/support" element={<Support />} />
              <Route path="/help" element={<Help />} />
          </Routes>
        </div>
        <Footer></Footer>
      </Router>
    </div>
  );
}

export default App;
