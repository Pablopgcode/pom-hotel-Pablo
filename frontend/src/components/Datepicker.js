import React, { Component } from 'react';
import DatePicker from 'react-datepicker';
import moment from 'moment';
 
import 'react-datepicker/dist/react-datepicker.css';
import 'assets/css/bootstrap.min.css';

class Datepicker extends Component {

  constructor (props) {
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
              selected={ this.state.startDate }
              onChange={ this.handleChange }
              name="startDate"
            dateFormat="dd/MM/yyyy"/>}   
          </div>
        </form>
      </div>
    );
  }
}

export default Datepicker;


{/* //Date Range with disabled navigation shown
// () => { 
//     const [startDate, setStartDate] = useState(null);
//     return (
//       <DatePicker
//         selected={startDate}
//         onChange={date => setStartDate(date)}
//         minDate={new Date()}
//         maxDate={addMonths(new Date(), 5)}
//         showDisabledMonthNavigation/>
//     );
// }; */}