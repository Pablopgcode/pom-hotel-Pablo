import React, { Component }  from 'react';
import Modal from "react-bootstrap/Modal";
import '../assets/css/bootstrap.min.css';
import '../assets/css/various-ui-comp.css';

 
class ThankPage extends Component {    
    constructor(props) {
        super(props)
        this.state = {
            bookingId: this.props.bookingId,
            name: this.props.name,
            startDate: this.props.startDate.toJSON().split("T")[0],
            endDate: this.props.endDate.toJSON().split("T")[0],
            totalPrice: this.props.totalPrice
        }
    }

    render() {
        return (
        <Modal show={true}>
            <div className="jumbotron text-center">
                <h2 className="display-5">Thank You!</h2>
                <p className="lead"><strong>Please check your email</strong> to view the details of your invoice.</p><hr></hr>
                <row>
                    <div className="col-10">
                        <img src={require("../assets/img/bg6.jpg")} className="img-fluid" alt="lobby" />
                    </div>
                    <div>
                        <p className="lead thText">Dear {this.state.name}, your reservation number is:</p><p className="lead lastPrice">#{this.state.bookingId}</p><p className="lead thText"> 
                        Your chosen dates are between {this.state.startDate} and {this.state.endDate}
                        . The last final price is {this.state.totalPrice}&#8364;</p>
                    </div>
                </row>
                <p className="lead"><a class="btn btn-primary btn-sm" href="/home/" role="button">Go to homepage</a></p>
                <small> Team POM Hotel </small>
            </div>
        </Modal>
    )};
};

export default ThankPage;















