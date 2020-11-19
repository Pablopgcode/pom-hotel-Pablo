import React from "react";
import { Container } from "reactstrap";
import {Link} from "react-router-dom";
import UncontrolledTooltip from "react";
const Mensajes = (props) => {
    let notice = "Offer if you come with a child! You have ";      
    return(
        <>
        {props.offer[0] && <React.Fragment>              
            {(props.guests == 3) ?  <p className="childrendisc"> {notice}{ props.offer[0].description}</p> : console.log("no offer")}
            {(props.guests == 4) ?  <p className="childrendisc"> {notice}{props.offer[0].description} or {props.offer[1].description}</p> : console.log("no offer")}
            {(props.guests > 4)  ?  <p className="childrendisc"> {notice} {props.offer[0].description} , {props.offer[1].description} or {props.offer[2].description}</p> : console.log("no offer")}           
        </React.Fragment>}
        </>
    );
}
const Room = (props) => {
    return (
        <Container>       
            <div className="row" style={{margin: '50px'}}>    
                <div className="col-md-6 col-sm-6">
                    <img className="img-raised" src={props.image}></img>
                </div>
                <div className="col-md-6 col-sm-6">
                    <h2>{props.name}</h2>
                    <p className="price"><h3>{props.pricePerNight} &#8364;<small>/ night</small></h3></p>
                    <p>{props.description}</p> 
                    <p className="price">for {props.guests} guests</p>
                    <Mensajes {...props}></Mensajes>     
                    <p><Link className="btn btn-primary" to={{pathname: "/pay/" + props.id,
                                                              state: {
                                                                  data: {
                                                                        startDate: props.startDate,
                                                                        endDate: props.endDate}
                                                              }}}
                    >Buy Now!</Link></p>
                </div>
            </div>                   
        </Container>      
    );
}

export default Room
