import React, { Component }  from 'react';
import '../../assets/css/bootstrap.min.css';
import '../../assets/css/various-ui-comp.css';
import Alert from 'react-bootstrap/Alert'
 
class AlertD extends Component {    
    constructor(props) {
        super(props)
        this.state = {
            message : this.props.message
        }
    }
    render() {      
            return (               
                <Alert className="discount" >
                    <Alert.Heading>Discount!</Alert.Heading>
                    <p>{this.state.message}</p>
                </Alert>              
            );
    }
}
  
export default AlertD