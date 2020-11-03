import React, { Component } from 'react';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import 'assets/css/bootstrap.min.css';
import '../assets/css/various-ui-comp.css'

class DateOut extends Component {

  constructor(props) {
    super(props)
    this.state = {
      startDate: new Date()
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(date) {
    this.setState({
      startDate: date
    })
  }

  handleSubmit(e) {
    e.preventDefault();
    let main = this.state.startDate
    console.log(main.format('L'));
  }

  render() {
    return (
      <div className = "container">
        <form onSubmit={ this.handleSubmit }>
          <div className="form-group">
            { <DatePicker
              className="datum"
              selected={ this.state.startDate}
              onChange={ this.handleChange }
              minDate={new Date()}
              name="checkout"
              dateFormat="dd/MM/yyyy"/>}  
          </div>
        </form>
      </div>     
    )                       
  }
}

export default DateOut;


