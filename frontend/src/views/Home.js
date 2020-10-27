import React from "react";

// core components
import IndexNavbar from "components/Navbars/IndexNavbar.js";
import IndexHeader from "components/Headers/IndexHeader.js";
import FirstFormPrefer from "components/FirstFormPrefer";

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
        <>
        <IndexNavbar />
        <div className="wrapper">
            <IndexHeader />
        </div>
        <FirstFormPrefer />
        
        
            
        
        </>
    )
}




export default Home;
