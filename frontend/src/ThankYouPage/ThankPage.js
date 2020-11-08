import React, { Component }  from 'react';
import Modal from "react-bootstrap/Modal";
import '../assets/css/bootstrap.min.css';
import '../assets/css/various-ui-comp.css';

// 
class ThankPage extends Component {    
    constructor(props) {
        super(props)
        this.state = {
            bookingId: this.props.bookingId
        }
    }

    render() {
        console.log("PEPE", this.props.bookingId);
        return (
        <Modal show={true}>
            <div class="jumbotron text-center">
                <h4 class="display-9">Thank You!</h4>
                <p class="lead"><strong>Please check your email</strong> to view the details of your invoice.</p><hr></hr>
                <row>
                    <div className="col-10">
                        <img src={require("../assets/img/bg6.jpg")} className="img-fluid" alt="lobby" />
                    </div>
                    <div>
                        <p>Dear friend, your reservation number is # {this.state.bookingId} # </p>
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















