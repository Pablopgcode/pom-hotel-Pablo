import React, { Component }  from 'react';
import '../../assets/css/bootstrap.min.css';
import '../../assets/css/various-ui-comp.css';
import Alert from 'react-bootstrap/Alert'
 
class AlertD extends Component {    
    constructor(props) {
        super(props)
        this.state = {
            
        }
    }
    render() {      
            return (               
                <Alert className="discount" >
                    <Alert.Heading>Discount!</Alert.Heading>
                    <p>5% for booking in low season</p>
                </Alert>              
            );
    }
}
  
export default AlertD