import React, { Component }  from 'react';
import '../../assets/css/bootstrap.min.css';
import '../../assets/css/various-ui-comp.css';
import Alert from 'react-bootstrap/Alert'
import { Container } from "reactstrap";
 
class AlertD extends Component {    
    constructor(props) {
        super(props)
        this.state = {
            show: this.props.show
        }
    }
    render() {      
        if (this.state.show) {
            return (               
                <Alert className="dataempty" variant="success" onClose={() => this.setState({show: false})} dismissible>
                    <Alert.Heading>Discount!</Alert.Heading>
                    <p>5% for booking in low season</p>
                </Alert>              
            );
        }
    }
}
  
export default AlertD