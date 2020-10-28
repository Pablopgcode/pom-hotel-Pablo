import React, { Component } from 'react';
import './../assets/css/various-ui-comp.css'
import Datepicker from "components/Datepicker.js";

class FirstFormPrefer extends Component{
  constructor(props){
    super(props);

    this.state = { term: '' };

    this.onInputChange = this.onInputChange.bind(this);
    this.onFormSubmit = this.onFormSubmit.bind(this);
}

onInputChange(event){
    this.setState({term: event.target.value});
}

onFormSubmit(event){
    event.preventDefault();
    this.props.onSearch(this.state.term);
    this.setState({term: ''});
}

render(){
    return(     
      
          <form method="post" action="/rooms">
              <div className="row div-form">
                  <div className="col-md-2">
                      <div>
                          <h2>Book Now</h2>
                          <span>Best Price Online</span>
                      </div>
                  </div>
                  <div className="col-md-3">
                      <div className="form-group">
                          <label for="checkin">Check-in:</label>
                          <div className="form-field">
                              <i className="icon icon-calendar2"></i>
                              {/* <input type="text" name="checkin" id="checkin" className="form-control date" placeholder="Check-in date"></input> */}
                              <Datepicker />
                          </div>
                      </div>
                  </div>
                  <div className="col-md-3">
                      <div className="form-group">
                          <label for="checkout">Check-out:</label>
                          <div className="form-field">
                              <i className="icon icon-calendar2"></i>
                              {/* <input type="text" name="checkout" id="checkout" className="form-control date" placeholder="Check-out date"></input> */}
                              <Datepicker />
                          </div>
                      </div>
                  </div>
                  <div className="col-md-2">
                      <div className="form-group">
                          <label for="guests">Guest</label>
                          <div className="form-field">
                              <i className="icon icon-arrow-down3"></i>
                              <select name="guests" id="guests" className="form-control">
                                  <option value="1">1</option>
                                  <option value="2" selected="">2</option>
                                  <option value="3">3</option>
                                  <option value="4">4</option>
                                  <option value="5">5+</option>
                              </select>
                          </div>
                      </div>
                  </div>
                  <div className="col-md-2 btn-cent">
                      <input className="btn btn-primary btn-block" type="submit" name="submit" id="submit" value="Find Rooms"></input>
                  </div>
              </div>
          </form>
    )
  }
}


export default FirstFormPrefer;