/*  P  R  I  N   C   I   P   A   L

*/
import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter, Route, Switch, Redirect } from "react-router-dom";

// styles for this kit
import "assets/css/bootstrap.min.css";
import "assets/scss/now-ui-kit.scss?v=1.4.0";
import "assets/demo/demo.css?v=1.4.0";
import "assets/demo/nucleo-icons-page-styles.css?v=1.4.0";
// pages for this kit
import Index from "views/Index.js";
import NucleoIcons from "views/NucleoIcons.js";
import LoginPage from "views/examples/LoginPage.js";
import LandingPage from "views/examples/LandingPage.js";
import ProfilePage from "views/examples/ProfilePage.js";
import Bookings from './test/test_all_bookings.jsx'
import Rooms from './test/test_all_rooms.jsx'
import Home from "views/Home.js";   // mi pagina home
ReactDOM.render(
  <BrowserRouter>
    <Switch>
      <Switch>
        {<Route path="/index" render={(props) => <Index {...props} />} /> }  //Plantilla
        {<Route path="/home" render={(props) => <Home {...props} />} /> }  //Mi home
        {/*<Route path="/index" render={(props) => <Bookings {...props} />} />*/}  
        <Route path="/rooms" render={(props) => <Rooms {...props} />} /> 
        {/* <Route
          path="/nucleo-icons"
          render={(props) => <NucleoIcons {...props} />}
        />
        <Route
          path="/landing-page"
          render={(props) => <LandingPage {...props} />}
        />
        <Route
          path="/profile-page"
          render={(props) => <ProfilePage {...props} />}
        />
        <Route
          path="/login-page"
          render={(props) => <LoginPage {...props} />}
        /> */}
        {/* <Redirect to="/index" /> */}
        <Redirect from="/" to="/index" />
      </Switch>
    </Switch>
  </BrowserRouter>,
  document.getElementById("root")
);
