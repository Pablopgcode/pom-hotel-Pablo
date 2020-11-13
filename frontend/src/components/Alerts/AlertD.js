import React, { Component }  from 'react';
import '../../assets/css/bootstrap.min.css';
import '../../assets/css/various-ui-comp.css';
import Alert from 'react-bootstrap/Alert'
 
const AlertD = (props) => {   
            return (               
                <Alert className="discount" >
                    <p>Discount! {props.msg}</p>
                </Alert>         
            );
}
  
export default AlertD