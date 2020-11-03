import React, { Component } from 'react';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import 'assets/css/bootstrap.min.css';
import '../../assets/css/various-ui-comp.css'
import TypeService from '../../services/typeService.js';


class Form extends Component {
    /* Props */
    constructor(props) {
        super(props)
        this.state = {
            rtypes: [],
            guests: 1,
            startDate: new Date(),
            endDate: this.startDate,
            type:{},
            minprice: 1,
            maxprice: 1000
        }
    }
    /*Handlers*/
    handleGuests (event){
        this.setState({value: event.target.value});
    }

    handleTypes (event){
        this.setState({value: event.target.value});
    }

    handleMinprice (event){
        this.setState({value: event.target.value});
    }

    handleMaxprice (event){
        this.setState({value: event.target.value});
    }

    handleprice(price){
        for (let i = 0; i < 5; i++) {
            // if (parseInt(maxprice.options[i].value) < parseInt(minPrice)) {
            //     this.setState ({...this.state, maxprice.options[i].hidden :true})
            // } else {
            //     this.setState ({...this.state, maxprice.options[i].hidden :false})
            // }
            // if (parseInt(minprice.options[i].value) > parseInt(maxPrice)) {
            //     this.setState ({...this.state, minprice.options[i].hidden :true})
            // } else {
            //     this.setState ({...this.state, minprice.options[i].hidden :false})
            // }
        }
    }



    /* obtain types of rooms */
    componentDidMount() {
        TypeService.getTypes().then((res) => {
            this.setState({ rtypes: res.data });
        });
    }

    render() {
        return (
            <div className="col-md-3">
                <div className="sidebar-wrap img-raised" style={{ margin: '50px' }}>
                    <div className="side search-wrap animate-box">
                        <h2 className="sidebar-heading">Find your room</h2>
                        <form method="post" action="/find" id="roomsSearch" className="colorlib-form">
                            <div className="row">
                                <div className="col-md-6">
                                    <div className="form-group">
                                        <label for="checkin">Check-in:</label>
                                            <div className="form-field">
                                            <DatePicker
                                                className="datum form-control"
                                                selected={ this.state.startDate}
                                                onChange={ (date) => this.setState({...this.state, startDate: date}) }
                                                minDate={new Date()}
                                                name="startDate"
                                                dateFormat="dd/MM/yyyy"/>
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
                                            onChange={  (date) => this.setState({...this.state, endDate: date})  }
                                            minDate={this.state.startDate}
                                            name="endDate"
                                            dateFormat="dd/MM/yyyy"/>
                                        </div>
                                    </div>
                                </div>
                                <div className="col-md-6">
                                    <div className="form-group">
                                        <label for="guests">Guest</label>
                                        <div className="form-field">
                                            <select id="guests" name="guests" className="form-control" value={this.state.value} onchange={this.handleGuests}>
                                                <option value="1">1</option>
                                                <option value="2" selected>2</option>
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
                                            <select name="type" id="roomtype" className="form-control" value={this.state.value} onchange={this.handleTypes}>
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
                                            <select name="minprice" id="pricefrom" className="form-control" onchange={this.handleprice}>
                                                <option value="1">1</option>
                                                <option value="50">50</option>
                                                <option value="100">100</option>
                                                <option value="200">200</option>
                                                <option value="300">300</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div className="col-md-6">
                                    <div className="form-group">
                                        <label for="priceto">Price to:</label>
                                        <div className="form-field">
                                            <select name="maxprice" id="priceto" className="form-control" onchange={this.handleprice}>
                                                <option value="100">100</option>
                                                <option value="200">200</option>
                                                <option value="300">300</option>
                                                <option value="500">500</option>
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

export default Form;

