import React from "react";
import { Container } from "reactstrap";
import roomService from "services/roomService";
import DarkFooter from "components/Footers/DarkFooter";
const Room = (props) => {
    
    return (
        <Container>       
            <div className="row" style={{margin: '50px'}}>    
                <div className="col-md-6 col-sm-6">
                    <img src={props.image}></img>
                </div>
                <div className="col-md-6 col-sm-6">
                    <h2>{props.name}</h2>
                    <p className="price"><h3>{props.pricePerNight} &#8364;<small>/ night</small></h3></p>
                    <p>{props.description}</p> 
                    <p><a class="btn btn-primary" href="/books/{props.id}">Book Now!</a></p>  
                </div>
            </div>                         
        </Container>      
    );
}

export default Room