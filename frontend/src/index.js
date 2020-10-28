/*  P  R  I  N   C   I   P   A   L

*/
import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter, Route, Switch, Redirect } from "react-router-dom";

// styles for this kit
import "assets/css/bootstrap.min.css";
import "assets/demo/demo.css?v=1.4.0";
import "assets/css/now-ui-kit.css";
import "assets/demo/nucleo-icons-page-styles.css?v=1.4.0";
import "assets/css/various-ui-comp.css";
// pages for this kit

import Rooms from './test/test_all_rooms.jsx'
import Home from "views/Home.js";   // mi pagina home
ReactDOM.render(
  <BrowserRouter>
    <Switch>
      <Switch>
      
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
        <Redirect from="/" to="/home" />
      </Switch>
    </Switch>
  </BrowserRouter>,
  document.getElementById("root")
);
