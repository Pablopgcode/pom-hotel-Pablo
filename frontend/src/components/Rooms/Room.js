import React from "react";
import { Container } from "reactstrap";
import {Link} from "react-router-dom";
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

/*  { (this.state.filter.guests >=3) ?  console.log("ofertas para la room.id ",room.id): console.log("No offers") }*/