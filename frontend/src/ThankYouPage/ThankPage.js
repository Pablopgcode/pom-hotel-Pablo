import React, { Component }  from 'react';
import Modal from "react-bootstrap/Modal";
import '../assets/css/bootstrap.min.css';
import '../assets/css/various-ui-comp.css';

const ThankPage = () => {
  return (
    <Modal show={true}>
        <div className="modalThanks">  
            <div className="modal-header">
                <h3>Dear </h3>
                <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true" className="white-text">&times;</span></button>
            </div>    
            <div className="modal-body">
                <div className="row">
                    <div className="col-5">
                        <img src={require("../assets/img/bg6.jpg")} className="img-fluid" alt="lobby" />
                    </div>
                    <div className="col-12">
                        <p><strong>Your booked with number #  #  and a total price of  &#8364; </strong></p>
                        <span>Thank you for booking with us</span><br></br>
                        <span>Vielen Dank für Ihre Buchung</span>
                    </div>
                </div>
            </div>
        </div>  
    </Modal>
  );
};

export default ThankPage;















