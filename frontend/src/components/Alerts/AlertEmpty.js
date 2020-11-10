import React, { Component }  from 'react';
import '../../assets/css/bootstrap.min.css';
import '../../assets/css/various-ui-comp.css';
import Alert from 'react-bootstrap/Alert'
import { Container } from "reactstrap";
 
class AlertEmpty extends Component {    
    constructor(props) {
        super(props)
        this.state = {
            show: this.props.show
        }
    }
    render() {      
        if (this.state.show) {
            return (
                
                    <Alert className="dataempty" variant="warning" onClose={() => this.setState({show: false})} dismissible>
                    <Alert.Heading>Wait!</Alert.Heading>
                        <p> Remember select dates before you booking </p>
                    </Alert>
               
            );
        }
    }
}
  
export default AlertEmpty