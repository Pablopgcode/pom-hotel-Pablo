import React, { Component } from 'react';
import RoomService from '../services/roomService.js';
import Navbar from "components/Navbars/Navbar.js";
import Header from 'components/Headers/Header.js';
import Room from 'components/Room.js';
import DarkFooter from "components/Footers/DarkFooter";
import Form from "components/Form";
import '../assets/css/various-ui-comp.css'

class Rooms extends Component {
    constructor(props) {
        super(props)
        this.state = {
            rooms: []
        }
    }
    componentDidMount(){
        RoomService.getRooms().then((res) => {               
            this.setState({ rooms : res.data });
        });
    }
    render() {
        return (
            <React.Fragment>
                <Navbar />
                <Header image={require("assets/img/revato-10251-13112723-111323.jpg")}/>
                <div className="col-md-9 offset-1 heading2 animate-box fadeInUp animated-fast">
                    <h2>Our Rooms</h2>
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
                    <Form />                   
                </div> 
                <DarkFooter />     
            </React.Fragment>
        )
    }
}
export default Rooms