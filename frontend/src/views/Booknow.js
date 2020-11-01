import React, { Component } from 'react';
import Header from 'components/Headers/Header.js';
import Navbar from "components/Navbars/Navbar.js";
import DarkFooter from "components/Footers/DarkFooter";
import Room from 'components/Room.js';
import RoomService from '../services/roomService.js';

class Booknow extends Component {
    constructor(props) {
        super(props)
        this.state = {
            room: {},
        }
    }
    
    componentDidMount(){
        let path = this.props.location.pathname;
        let p = path.split('/');
        
        RoomService.getRoomById(parseInt(p[2])).then((res) => {         
            this.setState({ room : res.data });
        });
    }

    render() { 
        return(

        <React.Fragment>
            <Navbar />
            <Header image={require("assets/img/bg6.jpg")}/>
            <div className="col-md-9 offset-1 heading2 animate-box fadeInUp animated-fast">
                <h3>Your choice, our wish</h3>
            </div>
                <div className="row">                          
                    <div className="col-md-7"> 
                    {
                        this.state.room.id ?                            
                                <div className="row" key={this.state.room.id}>
                                    <Room image={require("assets/img/rooms/"+this.state.room.image)} name={this.state.room.roomtypesByFkRoomtypeId.name} pricePerNight={this.state.room.pricePerNight} description={this.state.room.description}/>                               
                                </div>    
                        :<></>
                    }    
                    </div>                                                         
                </div> 
            <DarkFooter />
        </React.Fragment>
        )
    }
}
export default Booknow;