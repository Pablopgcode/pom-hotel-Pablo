import React, { Component } from 'react';
import 'assets/css/bootstrap.min.css';
import '../../assets/css/various-ui-comp.css'
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import GetTotalPrice from '../../services/bookingService.js';

class FormConfirmation extends Component {    
    constructor(props) {
        super(props)
        this.state = {
            startDate: this.props.startDate,
            endDate: this.props.endDate,
            totalPrice: null
        }
    }
    calculatePrice(end){
        this.setState({endDate: end})
        GetTotalPrice.getTotalPrice(this.state.startDate, end, this.props.id).then((res) => {
            this.setState({ totalPrice: res.data});
        })
    }
   
    render() {
        return (
                <div className="container">
                    <form id="booking" method="post">
                        <div className="row form-group">
                            <div id="checkOptions">
                                <h5> Add your options...</h5>
                                <label><input type="checkbox" />Safe box 12&#8364;/day</label>
                                <label><input type="checkbox" />Wedge 5&#8364;/day</label>
                                <label><input type="checkbox" />Laundry service 7&#8364;/day</label>
                                <label><input type="checkbox" />Parking inside 14&#8364;/day</label>
                            </div>
                        </div>
                        <hr></hr>
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
                                    <div className="form-group">
                                        <label for="checkin">Check-in:</label>
                                        <div className="form-field">
                                            <DatePicker
                                                className=" form-control"
                                                selected={ this.state.startDate}
                                                onChange={ (date) => this.setState({startDate: date}) }
                                                minDate={new Date()}
                                                name="startDate"
                                                dateFormat="dd/MM/yyyy"/>
                                        </div>
                                    </div>
                                </div>
                                <div className="col-md-5">
                                    <div className="form-group">
                                        <label for="checkout">Check-out:</label>
                                        <div className="form-field">
                                            <DatePicker
                                            className=" form-control"
                                            selected={ this.state.endDate<this.state.startDate ? this.state.startDate : this.state.endDate || this.state.startDate}
                                            onChange={  (date) => this.calculatePrice(date) }
                                            minDate={this.state.startDate}
                                            name="endDate"
                                            dateFormat="dd/MM/yyyy"/>
                                        </div>
                                    </div>
                                </div>
                                <div className="col-md-2">
                                    <label>Total Price</label>
                                    <input type="text" className="form-control" disabled>{this.state.totalPrice}</input>
                                </div>
                                <div className="form-group text-center col-md-12"><hr></hr>
                                    <input type="submit" value="Confirm Booking" className="btn btn-primary"></input>
                                </div>
                            </div>
                    </form>
                </div>                
          
        )
    }
}

export default FormConfirmation;