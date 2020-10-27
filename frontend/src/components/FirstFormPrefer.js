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
      <div className="div-form">
        <form onSubmit={this.onFormSubmit} className = "input-group">
            <Datepicker />
            <Datepicker />
            <span className="input-group-btn">
                <button type="submit" className="btn btn-secondary">Find rooms</button>
            </span>
        </form>
      </div>
    )
  }
}


export default FirstFormPrefer;