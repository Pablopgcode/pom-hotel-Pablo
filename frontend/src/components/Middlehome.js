import React from "react";
import '../assets/css/various-ui-comp.css'
import Space from "components/Space.js";

function Middlehome() {    
    
        return(
            <>
            <div className="colorlib-spaces colorlib-light-grey">
                <div className="container">
                    <div className="row">
                        <div className="col-md-6 col-md-offset-3 text-center colorlib-heading animate-box">
                            <h2>Popular Spaces</h2>
                            <p>We love to tell our successful, behind the roof of our hotel, far from the current world, here live the blind texts.</p>
                        </div>
                    </div>
                </div>
            </div>
            <div className="space-wrap">
                <Space image={require("assets/img/tour-1.jpg")} views=" 545 Reviews " message1="MEDITERRANEAN VIEWS" message2="Enjoy these amazing views" price="From $80"/>
                <Space image={require("assets/img/camere-4.jpg")} views=" 545 Reviews " message1="LUXURY ROOMS" message2="Enjoy your sensations" price="From $450"/>
                <Space image={require("assets/img/ok10.jpg")} views=" 545 Reviews " message1="SPA SAUNA" message2="Enjoy your care" price="From $20"/>
                <Space image={require("assets/img/high-performance.jpg")} views=" 545 Reviews " message1="UNDERWATER SPECIAL ROOMS" message2="Enjoy unique experiences" price="Soon..."/>
            </div>
            </>
        );
    
}

export default Middlehome;