import React, { Component } from 'react';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import 'assets/css/bootstrap.min.css';
import '../../assets/css/various-ui-comp.css'
import TypeService from '../../services/typeService.js';
import {now} from '../../services/dateservice';
class FormSearch extends Component {
    /* Props */
    constructor(props) {
        super(props)
        this.state = {
            rtypes: [],
            reserved: [],
            guests: "1",
            startDate: now,
            endDate: now,
            type: "",
            minprice: "1",
            maxprice: "1000"
        }
    }
    /* obtain types of rooms */
    componentDidMount() {
        TypeService.getTypes().then((res) => {
            this.setState({ rtypes: res.data });
        });
    }

    /*Handlers*/
    handleGuests (event){
        this.setState({guests: event.target.value});
    }

    handleTypes (event){
        this.setState({type: event.target.value}); 
    }

    handleMinprice (event){
        this.setState({minprice: event.target.value});
    }
    
    handleMaxprice (event){
        this.setState({maxprice: event.target.value});
    }

    submitFormData(ev){
        ev.preventDefault();
        this.props.onFilterChange(this.state)
    }
    
    render() {
        return (
            <div className="col-md-3">
                <div className="sidebar-wrap img-raised" style={{ marginTop: '50px' }}>
                    <div className="side search-wrap animate-box">
                        <h2 className="sidebar-heading">Find your room</h2>
                        <form onSubmit={(e)=> this.submitFormData(e)} id="roomsSearch" className="colorlib-form">
                            <div className="row">
                                <div className="col-md-6">
                                    <div className="form-group">
                                        <label for="checkin">Check-in:</label>
                                        <div className="form-field">
                                            <DatePicker
                                                className="datum form-control"
                                                selected={ this.state.startDate}
                                                onChange={ (date) => this.setState({startDate: date}) }
                                                minDate={new Date()}
                                                name="startDate"
                                                dateFormat="dd/MM/yyyy"
                                            />
                                        </div>
                                    </div>
                                </div>
                                <div className="col-md-6">
                                    <div className="form-group">
                                        <label for="checkout">Check-out:</label>
                                        <div className="form-field">
                                            <DatePicker
                                            className="datum form-control"
                                            selected={ this.state.endDate<this.state.startDate ? this.state.startDate : this.state.endDate || this.state.startDate}
                                            onChange={  (date) => this.setState({endDate: date})  }
                                            minDate={this.state.startDate}
                                            name="endDate"
                                            dateFormat="dd/MM/yyyy"
                                            />
                                        </div>
                                    </div>
                                </div>
                                <div className="col-md-6">
                                    <div className="form-group">
                                        <label for="guests">Guest</label>
                                        <div className="form-field">
                                            <select id="guests" name="guests" className="form-control" value={this.state.guests} onChange={(e) => this.handleGuests(e)}>
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                                <option value="4">4</option>
                                                <option value="5">5+</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div className="col-md-6">
                                    <div className="form-group">
                                        <label for="roomtypes">Room Types</label>
                                        <div className="form-field"> 
                                            <select name="type" id="roomtype" className="form-control" value={this.state.value} onChange={(e) => this.handleTypes(e)}>
                                                <option value="0">All types</option>
                                                {
                                                    this.state.rtypes.map(
                                                        type =>
                                                            <option value={type.id}>{type.name}</option>
                                                    )
                                                }
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div className="col-md-6">
                                    <div className="form-group">
                                        <label for="pricefrom">Price from:</label>
                                        <div className="form-field">
                                            <select name="minprice" id="pricefrom" className="form-control" value={this.state.minprice} onChange={(e) => this.handleMinprice(e)}>
                                                <option value="1" disabled={this.state.maxprice < 1 ? 'true' : ''}>1</option>
                                                <option value="50" disabled={this.state.maxprice < 50 ? 'true' : ''}>50</option>
                                                <option value="100" disabled={this.state.maxprice < 100 ? 'true' : ''}>100</option>
                                                <option value="200" disabled={this.state.maxprice < 200 ? 'true' : ''}>200</option>
                                                <option value="300" disabled={this.state.maxprice < 300 ? 'true' : ''}>300</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div className="col-md-6">
                                    <div className="form-group">
                                        <label for="priceto">Price to:</label>
                                        <div className="form-field">
                                            <select name="maxprice" id="priceto" className="form-control" value={this.state.maxprice} onChange={(e) => this.handleMaxprice(e)}>
                                                <option value="100" disabled={this.state.minprice > 100 ? 'true' : ''}>100</option>
                                                <option value="200" disabled={this.state.minprice > 200 ? 'true' : ''}>200</option>
                                                <option value="300" disabled={this.state.minprice > 300 ? 'true' : ''}>300</option>
                                                <option value="500" disabled={this.state.minprice > 500 ? 'true' : ''}>500</option>
                                                <option value="1000">1000</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div className="col-md-12">
                                    <input type="submit" name="submit" id="submit" value="Find Room" className="btn btn-primary btn-block"></input>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        )
    }   
}

export default FormSearch;

