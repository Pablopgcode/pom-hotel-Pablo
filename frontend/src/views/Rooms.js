import React, { Component } from 'react';
import RoomService from '../services/roomService.js';
import Navbar from "components/Navbars/Navbar.js";
import Header from 'components/Headers/Header.js';
import Room from 'components/Room.js';
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
                <div class="col-md-8 col-md-offset-0 heading2 animate-box fadeInUp animated-fast">
                    <h2>Our Rooms</h2>
                </div>
                <div className="Row">                  
                    {
                        this.state.rooms.map(
                            room => 
                                <Room image={require("assets/img/rooms/camere-2.jpg")} name={room.name} price={room.price} description={room.description}/>   
                        )
                    }                          
                </div> 
            </React.Fragment>
        )
    }
}
export default Rooms