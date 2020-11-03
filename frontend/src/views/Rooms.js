import React, { Component } from 'react';
import RoomService from '../services/roomService.js';
import Navbar from "components/Navbars/Navbar.js";
import Header from 'components/Headers/Header.js';
import Room from 'components/Rooms/Room.js';
import DarkFooter from "components/Footers/DarkFooter.js";
import FormSearch from "components/Forms/FormSearch.js";
import '../assets/css/various-ui-comp.css';

class Rooms extends Component {
    constructor(props) {
        super(props)
        this.state = {
            rooms: [],
            fiter: {}
        }
        
    }
    componentDidMount(){
        RoomService.getRooms().then((res) => {               
            this.setState({ rooms : res.data });
        });
    }

    updateFilter(filter){
        console.log('updateFilter.filter: ', filter)
        // this.setState ({filter:filter})
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
                                <Room image={require("assets/img/rooms/"+room.image)} id={room.id} name={room.roomtypesByFkRoomtypeId.name} pricePerNight={room.pricePerNight} guests={room.guests} description={room.description}/>                           
                            </div>    
                        )
                    } 
                    </div>                   
                    <FormSearch onFilterChange={this.updateFilter.bind(this)} />                   
                </div> 
                <DarkFooter />     
            </React.Fragment>
        )
    }
}
export default Rooms