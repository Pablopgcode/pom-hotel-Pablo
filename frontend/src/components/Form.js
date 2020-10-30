import React, { Component } from 'react';
import 'react-datepicker/dist/react-datepicker.css';
import 'assets/css/bootstrap.min.css';
import DateIn from 'components/DateIn'
import '../assets/css/various-ui-comp.css'

class Form extends Component {

    constructor(props) {
        super(props)
        this.state = {
         
        };
       
      }
       
    
      render() {
        return (
            
            <div className="sidebar-wrap" style={{margin: '50px'}}>
                <div className="side search-wrap animate-box fadeInUp animated-fast">
                    <h3 className="sidebar-heading">Find your room</h3>
                    <form method="post" action="" className="colorlib-form">
                        <div className="row">
                            <div className="col-md-12">
                                <div className="form-group">
                                    <label for="checkin">Check-in:</label>
                                    <div className="form-field">
                                        <i className="icon icon-calendar2"></i>
                                        <DateIn/>
                                    </div>
                                </div>
                            </div> 
                        </div>       





                                        

                        
                            






                    </form>
                </div>
            </div>
        )                       
      }
}

export default Form;