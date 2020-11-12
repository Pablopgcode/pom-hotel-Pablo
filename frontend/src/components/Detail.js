
import React, { Component } from 'react';
import 'assets/css/bootstrap.min.css';
import '../assets/css/various-ui-comp.css'

const Detail = (props) => {

    return (
        <div id="colorlib-contact" className="colorlib-wrap">
            <div className="container">
                <div className="row">
                    <div className="col-md-10 col-md-offset-1 animate-box">
                        <h2>Book your room</h2>                      
                        <div className="row form-group">
                            <div className="col-md-3 padding-bottom">
                                <label>Room Code</label>
                                <input type="text" className="form-control" value={props.code} readonly></input>
                            </div>
                            <div className="col-md-3 padding-bottom">
                                <label>Type</label>
                                <input type="text" className="form-control" value={props.type} readonly></input>
                            </div>
                            <div className="col-md-3 padding-bottom">
                                <label>Guests</label>
                                <input type="text" className="form-control" value={props.guests} readonly></input>
                            </div> 
                            <div className="col-md-3">
                                <label>Price per night</label>
                                <input type="text" className="form-control" value={props.price} readonly></input>
                            </div>
                        </div>

                        <div className="row form-group">
                            <div className="col-md-12 padding-bottom">
                                <div className="room-img">
                                <img className="img-raised" src={props.image}></img>
                            </div>
                        </div>
                        <div className="col-md-12 padding-bottom">
                            <label>Description</label>
                            <textarea type="text" className="form-control textarea" readonly>{props.description}</textarea>
                        </div>
                    </div>                        
                </div>                      
            </div>
        </div>                
    </div>     
    )
}

export default Detail;