import React from "react";
import Navbar from "components/Navbars/Navbar.js";
import Header from "components/Headers/Header";
import DarkFooter from "components/Footers/DarkFooter";
import '../assets/css/various-ui-comp.css'
import ThankPage from '../ThankYouPage/ThankPage.js';

const About = (props) => {
    return (
        <React.Fragment>
            <Navbar />
            <div class="marketing-formatting">
                <section class="page-block page-block--color page-block--color--peach">
                    <div className="container-flex">
                        <div className="page-block__content--tall">
                            <div className="col-6 col-center type-center">
                                <h1 className="type-mega--sans">Love Code?</h1>
                                <h2>You’ll fit right in.</h2>
                                <p className="type-base--serif">We are looking for a real change in our day to day. Do you dare to follow us?</p>
                            </div>
                        </div>
                        <div className="color-callout color-callout--pull-up blue">
                            <div className="color-callout__content">
                                <h2 className="type-kilo--sans">A special group</h2>
                                <div className="type-med--serif">
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <section class="page-block page-block--image page-block--pull-up jobs-1"> 
                </section>
                <section class="page-block">
                    <div class="container-flex">
                        <div class="page-block__content">
                            <div class="col col-5 col-post-1">
                                <p class="type-xl--sans">We work as a team.</p>
                            </div>
                            <div class="col col-6">
                                <p class="type-base--serif">
                                    
                                </p>
                            </div>
                        </div>
                    </div>
                </section>
            </div>











        </React.Fragment>
    )
}
export default About;