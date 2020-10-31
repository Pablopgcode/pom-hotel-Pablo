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
            rooms: []
        }
    }
    
    componentDidMount(){
        
        RoomService.getRoomById().then((res) => {               
            this.setState({ rooms : res.data });
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
                            this.state.rooms.map(
                                room =>
                                <div className="row" key={room.id}>   
                                    <Room image={require("assets/img/rooms/"+room.image)} name={room.roomtypesByFkRoomtypeId.name} pricePerNight={room.pricePerNight} description={room.description}/>
                                </div>    
                            )
                        } 
                        </div>                                    
                </div> 
            <DarkFooter />
        </React.Fragment>
        )
    }
}
export default Booknow;