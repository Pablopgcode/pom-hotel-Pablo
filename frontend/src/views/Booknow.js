import React from "react";

import Navbar from "components/Navbars/Navbar.js";
import DarkFooter from "components/Footers/DarkFooter";
import { isPropertySignature } from "typescript";

//function Booknow() {
const Booknow = (props) => {
    return(

        <React.Fragment>
            <Navbar />
            <div>
                <p>{props.id}</p>
            </div>



            <DarkFooter />

        </React.Fragment>



    )








}
export default Booknow;