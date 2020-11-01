import React, { Component } from 'react';
import Header from 'components/Headers/Header.js';
import DarkFooter from "components/Footers/DarkFooter";
import Navbar from "components/Navbars/Navbar.js";

class Pay extends Component {
    constructor(props) {
        super(props)
        this.state = {
           
        }
    }
    
    componentDidMount(){
        
       
    }

    render() { 
        return(

        <React.Fragment>
            <Navbar />
            <Header image={require("assets/img/high-performance.jpg")}/>
            
            <DarkFooter />
        </React.Fragment>
        )
    }
}
export default Pay;