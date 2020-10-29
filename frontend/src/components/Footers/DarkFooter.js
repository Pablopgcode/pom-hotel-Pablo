/*eslint-disable*/
import React from "react";

// reactstrap components
import { Container } from "reactstrap";

function DarkFooter(){
  return (
    <footer className='text-muted bg-light'>
        <div id='colorlib-footer' role='contentinfo'>
            <div id="footer" className="container-fluid">
                <div className='row row-pb-md justify-content-center'>
                    <div className='col-12 col-md-6 col-lg-4 colorlib-widget'>
                        <h5>POM dreams</h5>
                        <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Quasi voluptatem quisquam, labore nesciunt modi officiis alias architecto blanditiis, accusamus, aut eius? </p>
                        <p>Dicta necessitatibus neque perferendis aperiam iste sint cum dolor fugiat nisi temporibus aut!</p>
                    </div>              
                    <div className='col-12 col-md-6 col-lg-4 colorlib-widget text-center'>
                        <h5>Play music</h5>
                        <p>Listen the best songs</p>
                        <p><a href='https://youtu.be/GJkuTx1DQzg' target='_blank'><img src={require('assets/img/musica.png')}  width='60rem' height='60rem'/></a></p>
                        <p>Click on the icon</p>
                    </div>
                    <div className='col-12 col-md-6 col-lg-4 colorlib-widget'>
                        <h5>Contact Information</h5>
                        <ul class='colorlib-footer-links'>
                            <li>Aulas Formación B-3, <br /> Carretera Nacional II (complejo seat Autovia a-2), KM 585, Martorell, 08760, Barcelona </li>
                            <li><a href='tel://1234567920'>+ 1235 2355 98</a></li>
                            <li><a href='mailto:info@yoursite.com'>pom@party.com</a></li>
                            <li><a href='#'>pomhotel.com</a></li>
                        </ul>
                    </div>
                </div>
                <div className='row'>
                    <div className='col-md-12 text-center'>
                        <p><span> Copyright ©<script>document.write(new Date().getFullYear());</script>2020 All rights reserved to <a href='https://code.seat/' target='_blank'>@Z-Devs</a>  |  This webside is made by: <a href='https://github.com/Z-devs/pom-hotel.git' target='_blank'>@Pablo</a>, <a href='https://github.com/Z-devs/pom-hotel.git' target='_blank'>@Oscar</a>,<a href='https://github.com/Z-devs/pom-hotel.git' target='_blank'>@Miguel</a>.</span></p>
                    </div>
                </div>
            </div>
        </div>           
    </footer>
  );
}

export default DarkFooter;
