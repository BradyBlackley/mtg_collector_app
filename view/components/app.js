import Banner from "./banner/banner";
import Navigation from "./navigation/navigation";
import Main from "./main/main";
import Footer from "./footer/footer";

const App = () => {
    return (
        <div>
            <Banner headerText = "Magic The Gathering Collector&apos;s App"/>
            <Navigation />
            <Main />
            <Footer />
        </div>
    );
};

export default App;