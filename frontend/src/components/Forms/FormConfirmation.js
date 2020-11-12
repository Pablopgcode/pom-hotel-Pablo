import React, { Component } from 'react';
import 'assets/css/bootstrap.min.css';
import '../../assets/css/various-ui-comp.css'
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import GetTotalPrice from '../../services/bookingService.js';
import SaveBooking from '../../services/bookingService.js';
import ThankPage from '../../ThankYouPage/ThankPage.js';
import Alert from '../../components/Alerts/Alert.js'
class FormConfirmation extends Component {    
    constructor(props) {
        super(props)
        this.state = {
            startDate: this.props.startDate,
            endDate: this.props.endDate,
            totalPrice: null,
            bookingId: 0,
            safebox: false,
            wedge: false,
            laundry: false,
            parking: false,
            name: '',
            offSeason: false,
        }
        this.handleCheck = this.handleCheck.bind(this);
        this.handleDateCheckin = this.handleDateCheckin.bind(this);
        this.handleDateCheckout = this.handleDateCheckout.bind(this);
        this.handleChangeName = this.handleChangeName.bind(this);
    }

    verifySesion (){
        let offSesions = [0,1,2,3,4,5,9,10,11]; /* I consider high season July, August and September */
        if(offSesions.includes(this.state.startDate.getMonth()) && offSesions.includes(this.state.endDate.getMonth())){
            this.setState({offSeason: true})      
        }else{
            this.setState({offSeason: false})  
        }       
    }

    calculatePrice(){
        GetTotalPrice.getTotalPrice(this.state.startDate, this.state.endDate, this.props.room.id,  this.state.safebox, this.state.wedge, this.state.laundry, this.state.parking).then((res) => {
            this.setState({ totalPrice: res.data}); 
        })
    }

    componentDidMount(){
        this.verifySesion (this.state.startDate, this.state.endDate);
        GetTotalPrice.getTotalPrice(this.state.startDate, this.state.endDate, this.props.room.id).then((res) => {
            this.setState({ totalPrice: res.data});          
        })
    }
    
    /* handle checkboxes */
    handleCheck = (event) => {
        const target = event.target;
        const value = target.type === 'checkbox' ? target.checked : target.value;
        const name = target.name;
        this.setState({
          [name]: value
        }, () => {
            this.calculatePrice();
        });     
    }

    /* handle dates */
    handleDateCheckin = (event) => {
        this.setState({
          startDate: event
        }, () => {
            this.verifySesion(); 
            this.calculatePrice();
        });
          
    }

    handleDateCheckout = (event) => {
        this.setState({
          endDate: event
        }, () => {
            this.verifySesion();  
            this.calculatePrice();
        }); 
             
    }

    handleChangeName(event) { this.setState({name: event.target.value});}

    submitFormData(ev){
        const sqlStartDate = this.state.startDate.toJSON().split("T")[0];
        const sqlEndDate = this.state.endDate.toJSON().split("T")[0];      
        ev.preventDefault();
        SaveBooking.saveBooking (this.props.room.id, 
                                sqlStartDate, 
                                sqlEndDate,
                                this.state.totalPrice,
                                this.state.safebox,
                                this.state.wedge,
                                this.state.laundry,
                                this.state.parking).then((res) => {
                                    this.setState({bookingId: res.data});                    
                                })
    }
    
    render() {
        return (
                <div className="container formc">
                    <form id="booking" onSubmit={(e)=> this.submitFormData(e)} >                      
                        <br></br>
                        <div className="row form-group">
                            <div className="col-md-12 padding-bottom">
                                <label>Your Name, First Name and Last Name</label>
                                <input type="text" class="form-control" value={this.state.name} onChange={this.handleChangeName}></input>
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
                        <div class="form-group col-12"><hr></hr>
                            <div className="row">
                                <div className="col-md-4">
                                    <div className="form-group">
                                        <label for="checkin">Check-in:</label>
                                        <div className="form-field">
                                            <DatePicker
                                                className=" form-control"
                                                selected={ this.state.startDate}                                            
                                                onChange = {this.handleDateCheckin}                                                                                              
                                                minDate={new Date()}
                                                name="startDate"
                                                dateFormat="dd/MM/yyyy"/>
                                        </div>
                                    </div>
                                </div>
                                <div className="col-md-4">
                                    <div className="form-group">
                                        <label for="checkout">Check-out:</label>
                                        <div className="form-field">
                                            <DatePicker
                                            className=" form-control"
                                            selected= {this.state.endDate < this.state.startDate ? this.state.startDate : this.state.endDate || this.state.startDate}
                                            onChange = {this.handleDateCheckout}             
                                            minDate={this.state.startDate}
                                            name="endDate"
                                            dateFormat="dd/MM/yyyy"/>
                                        </div>
                                    </div>
                                </div>
                            </div>    
                        </div>
                        <div className="row form-group">
                            <div>
                                <p className="optio">If you wish you can add options ...</p>
                                <label><input type="checkbox"  name="safebox" checked={this.state.safe} onChange={this.handleCheck} />Safe box 12&#8364;/day</label>
                                <label><input type="checkbox"  name="wedge" checked={this.state.wedge} onChange={this.handleCheck}/>Wedge 5&#8364;/day</label>
                                <label><input type="checkbox"  name="laundry" checked={this.state.laundry} onChange={this.handleCheck}/>Laundry service 7&#8364;/day</label>
                                <label><input type="checkbox"  name="parking" checked={this.state.parking} onChange={this.handleCheck}/>Parking inside 14&#8364;/day</label>
                            </div>
                        </div><hr></hr>
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
                            <div className="col-md-2">
                                <label>Total Price</label>
                                <input type="text" className="form-control befprice" disabled value={this.state.totalPrice}></input>
                            </div> 
                            {this.state.offSeason != false  && <Alert />}                    
                        </div>
                        <div className="form-group text-center col-md-12"><hr></hr>
                            <input type="submit" value="Confirm Booking" className="btn btn-primary"></input>
                        </div>  
                        {this.state.bookingId != 0 && <ThankPage bookingId={this.state.bookingId} startDate={this.state.startDate} endDate={this.state.endDate} totalPrice={this.state.totalPrice} name={this.state.name}/>}
                    </form>                   
                </div>                                              
        )        
    }
}

export default FormConfirmation;