import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter, Route, Switch, Redirect } from "react-router-dom";

// styles for this kit
import "assets/css/bootstrap.min.css";
import "assets/css/now-ui-kit.css";
import "assets/css/various-ui-comp.css";
import Rooms from "views/Rooms.js";
import Home from "views/Home.js";  
import About from "views/About.js"; 
import Booknow from "views/Booknow.js";
import Pay from "views/Pay.js";

ReactDOM.render(
  <BrowserRouter>
    <Switch>
      <Switch>     
        <Route path="/home" render={(props) => <Home {...props} />} />   
        <Route path="/rooms" render={(props) => <Rooms {...props} />} /> 
        <Route path="/find" render={(props) => <Booknow {...props} />} /> 
        <Route path="/about" render={(props) => <About {...props} />} /> 
        <Route path="/pay/:id" render={(props) => <Pay {...props} />} />     
        <Redirect from="/" to="/home" />
      </Switch>
    </Switch>
  </BrowserRouter>,
  document.getElementById("root")
);
