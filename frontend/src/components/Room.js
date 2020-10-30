import React from "react";
import { Container } from "reactstrap";
import roomService from "services/roomService";

const Room = (props) => {
    console.log('room: ',props);
    return (



        <Container>
            <div className="row">
                <div className="col-md-6 col-sm-6">
                    <img src={props.image}></img>
                </div>
                <div className="col">
                    <h2>{props.name}</h2>
                    <p><h3>{props.pricePerNight} <small>/ night</small></h3></p>
                    <p>{props.description}</p> 
                </div>
            </div>
        



                               
        </Container>
    );
}

export default Room


//  <div className="col-md-12 animate-box">
//                 <div className="room-wrap">
//                     <div className="row">
//                         <div className="col-md-6 col-sm-6">
//                             <div className="" style={{backgroundColor: "dimgrey"}}>
//                                 <div className="" style={{ backgroundImage: "url(" + props.image +")", backgroundSize: "cover"}}>
//                                 </div>
//                             </div>
//                         </div>
//                         <div className="col-md-6 col-sm-6">
//                             <div className="desc">
//                                 <h2>{props.name}</h2>
//                                  <p className="price"><span>{props.pricePerNight}</span><small>/ night</small></p>
//                                 <p>{props.description}</p> 
//                                 {/* <p><a className="btn btn-primary" {/bookroomnow/{id}(id=${room.id})}">Book Now!</a></p>
//                                 <p><a className="btn btn-primary" {/bookroomnow/(id = ${ room.id }, checkin = ${ checkin }, checkout = ${ checkout })}">Book Now!</a></p>  */}
//                             </div>
//                         </div>
//                     </div>
//                 </div>
//             </div>              
                                                