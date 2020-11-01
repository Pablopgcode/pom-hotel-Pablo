import React from "react";
import Navbar from "components/Navbars/Navbar.js";
import Header from "components/Headers/Header";
import DarkFooter from "components/Footers/DarkFooter";
import '../assets/css/various-ui-comp.css'

const About = (props) => {
    return (
        <React.Fragment>
            <Navbar />
            <div class="marketing-formatting">
                <section class="page-block page-block--color page-block--color--peach">
                    <div className="container-flex">
                        <div className="page-block__content--tall">
                            <div className="col-6 col-center type-center">
                                <h1 className="type-mega--sans">Love Coder?</h1>
                                <h2>You’ll fit right in.</h2>
                                <p className="type-base--serif">We’re looking for dedicated, creative people to join us in making Kickstarter even better. Is that you?</p>
                            </div>
                        </div>
                        <div className="color-callout color-callout--pull-up blue">
                            <div className="color-callout__content">
                                <h2 className="type-kilo--sans">It’s work that matters.</h2>
                                <div className="type-med--serif">Kickstarter is changing how millions of people around the world engage with art and creativity. There’s something special about knowing your hard work and talents are helping tens of thousands of creative projects come to life.
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
                                    Team Kickstarter is only just over a hundred people — still a tight-knit group, considering everything that’s happened so far. Every week brings new challenges, and every week we work together to meet them. (We also have plenty of fun together: hack days, happy hours, trips, workshops, movies, lunches, and a lot of laughing.)
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