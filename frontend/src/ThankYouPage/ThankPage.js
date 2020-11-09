import React, { Component }  from 'react';
import Modal from "react-bootstrap/Modal";
import '../assets/css/bootstrap.min.css';
import '../assets/css/various-ui-comp.css';

 
class ThankPage extends Component {    
    constructor(props) {
        super(props)
        this.state = {
            bookingId: this.props.bookingId,
            startDate: this.props.startDate,
            endDadte: this.props.endDate,
            totalPrice: this.props.totalPrice
        }
    }

    render() {
        return (
        <Modal show={true}>
            <div class="jumbotron text-center">
                <h3 class="display-7">Thank You!</h3>
                <p class="lead"><strong>Please check your email</strong> to view the details of your invoice.</p><hr></hr>
                <row>
                    <div className="col-10">
                        <img src={require("../assets/img/bg6.jpg")} className="img-fluid" alt="lobby" />
                    </div>
                    <div>
                        <p className="thText">Dear friend, your reservation number is # {this.state.bookingId} # 
                        your chosen dates are between {this.state.startDate} and {this.state.endDate}
                        . The final price is {this.state.totalPrice} &#8364;</p>
                    </div>
                </row>
                <p>Having trouble? <a href="">Contact us</a>
                </p>
                <p class="lead"><a class="btn btn-primary btn-sm" href="/home/" role="button">Go to homepage</a></p>
            </div>
        </Modal>
    )};
};

export default ThankPage;















