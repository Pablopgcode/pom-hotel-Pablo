
import React, { Component } from 'react';
import 'assets/css/bootstrap.min.css';
import '../../assets/css/various-ui-comp.css'

const FormConfirmation = (props) => {
        console.log(props);
        return (
            <div id="colorlib-contact" className="colorlib-wrap">
                <div className="container">
                    <div className="row">
                        <div className="col-md-10 col-md-offset-1 animate-box">
                            <h2>Book your room</h2>
                            <form id="booking" method="post">
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
                                    <div className="col-md-6 padding-bottom">
                                        <div className="room-img">
                                        <img className="img-raised" src={props.image}></img>
                                        </div>
                                    </div>
                                    <div className="col-md-6 padding-bottom">
                                        <label>Description</label>
                                        <textarea type="text" className="form-control textarea" readonly>{props.description}</textarea>
                                    </div>
                                </div>
                                <div className="row form-group">
                                    <div id="checkOptions">
                                        <h3>Add your options...</h3>
                                        <label><input type="checkbox" />Safe box 12&#8364;/day</label>
                                        <label><input type="checkbox" />Wedge 5&#8364;/day</label>
                                        <label><input type="checkbox" />Laundry service 7&#8364;/day</label>
                                        <label><input type="checkbox" />Parking inside 14&#8364;/day</label>
                                    </div>
                                </div>
                                <hr className="stronghr"></hr>
                                <div className="row form-group">
                                    <div className="col-md-12 padding-bottom">
                                        <label>Your Name, First Name and Last Name</label>
                                        <input type="text" class="form-control"></input>
                                    </div>
                                </div>
                                <div className="row form-group">
                                    <div className="col-md-4 padding-bottom">
                                        <label>Your Adress</label>
                                        <input type="text" class="form-control"></input>
                                    </div>
                                    <div className="col-md-4 padding-bottom">
                                        <label>Your telephone number</label>
                                        <input type="text" class="form-control"></input>
                                    </div>
                                    <div className="col-md-4 padding-bottom">
                                        <label>Your e-mail</label>
                                        <input type="text" class="form-control"></input>
                                    </div>
                                </div>
                                <h4>INVOICE</h4>
                                <div className="row form-group">
                                    <div className="col-md-4 padding-bottom">
                                        <label>Card number</label>
                                        <input type="text" class="form-control"></input>
                                    </div>
                                    <div className="col-md-4 padding-bottom">
                                        <label>Name on card</label>
                                        <input type="text" class="form-control"></input>
                                    </div>
                                    <div className="col-md-4 padding-bottom">
                                        <label>Expiry date</label>
                                        <input type="text" class="form-control"></input>
                                    </div>
                                    <div className="col-md-4 padding-bottom">
                                        <label>Security code</label>
                                        <input type="text" class="form-control"></input>
                                    </div>
                                    <div className="col-md-4 padding-bottom">
                                        <label>Admitted</label>
                                        <br></br>
                                        <img src={require("assets/img/Pagos.png")}></img>
                                    </div>
                                </div>
                                <div class="form-group col-12"><hr></hr></div>
                                <div className="row">
                                    <div className="col-md-5">
                                        <label>Check In</label>
                                        <input type="text" id="checkinVisible" className="form-control" disabled></input>
                                        <input type="hidden" id="checkin" className="form-control" readonly></input>
                                    </div>
                                    <div className="col-md-5">
                                        <label>Check Out</label>
                                        <input type="text" id="checkoutVisible" className="form-control" disabled></input>
                                        <input type="hidden" id="checkout" className="form-control" readonly></input>
                                    </div>
                                    <div className="col-md-2">
                                        <label>Total Price</label>
                                        <input type="text" className="form-control" disabled></input>
                                    </div>
                                    <div className="form-group text-center col-md-12">
                                        <input type="submit" value="Confirm Booking" className="btn btn-primary"></input>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>                
                </div>
            </div>
        )
}

export default FormConfirmation;