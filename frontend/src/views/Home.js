import React from "react";

// core components
import Navbar from "components/Navbars/Navbar.js";
import Header from "components/Headers/Header.js";
import Middlehome from "components/Middlehome";
import DarkFooter from "components/Footers/DarkFooter";

function Home() {
    React.useEffect(() => {
        document.body.classList.add("index-page");
        document.body.classList.add("sidebar-collapse");
        document.documentElement.classList.remove("nav-open");
        window.scrollTo(0, 0);
        document.body.scrollTop = 0;
        return function cleanup() {
          document.body.classList.remove("index-page");
          document.body.classList.remove("sidebar-collapse");
        };
    });
    return(
      
    <React.Fragment>
        <Navbar />     
        <Header image={require("assets/img/mynamar.jpg")}/>
        <Middlehome />  
        <DarkFooter />
    </React.Fragment>           
    )
}

export default Home;
