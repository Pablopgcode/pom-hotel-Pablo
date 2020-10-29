import React from "react";
import { Container } from "reactstrap";

const Room = (props) => {
    return (
        <Container>
            <div className="col-md-12 animate-box">
                <div className="room-wrap">
                    <div className="row">
                        <div className="col-md-6 col-sm-6">
                            <div className="room-img" style="background-color: dimgrey;">
                                <div className="room-img" style={{ backgroundImage: "url(" + props.image + ")", backgroundSize: "cover"}}>
                                </div>
                            </div>
                        </div>
                        <div className="col-md-6 col-sm-6">
                            <div className="desc">
                                <h2>{props.name}</h2>
                                <p className="price"><span>{props.price}</span><small>/ night</small></p>
                                <p>{props.description}</p>
                                {/* <p><a className="btn btn-primary" {/bookroomnow/{id}(id=${room.id})}">Book Now!</a></p>
                                <p><a className="btn btn-primary" {/bookroomnow/(id = ${ room.id }, checkin = ${ checkin }, checkout = ${ checkout })}">Book Now!</a></p> */}
                            </div >
                        </div >
                    </div >
                </div >
            </div>                                 
        </Container >
    );
}

export default Room