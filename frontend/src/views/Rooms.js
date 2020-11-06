import React, { Component } from 'react';
import RoomService from '../services/roomService.js';
import Navbar from "components/Navbars/Navbar.js";
import Header from 'components/Headers/Header.js';
import Room from 'components/Rooms/Room.js';
import DarkFooter from "components/Footers/DarkFooter.js";
import FormSearch from "components/Forms/FormSearch.js";
import '../assets/css/various-ui-comp.css';
import {now} from '../services/dateservice';
import {parseISO} from 'date-fns';

class Rooms extends Component {
    constructor(props) {
        super(props)
        this.state = {
            rooms: [],
            excluded: [],
            filter: {startDate: now}
        }       
    }

    componentDidMount(){
        let rooms = []
        RoomService.getRooms().then((res) => {  
            rooms = res.data;
            this.setState({ rooms : res.data });
        })
        
        console.log('mount.rooms ',rooms)
        let excluded = [];
        const l = rooms.length;
        for (let i=0; i<l; i++){
            excluded = rooms[i].booked.map((date) => parseISO(date));
        }
        console.log('excluded: ',excluded);
    }

    updateFilter(filter){
        console.log('updateFilter.filter: ', filter)
        this.setState ({filter:filter})   
    }
                                                                          
    render() { 
        console.log("Rooms con reservas: ", this.state.rooms);
        const roomsFiltered = this.state.rooms.filter((room) => {
            let validPricePerNightFrom = this.state.filter.minprice  
            ? room.pricePerNight >= +this.state.filter.minprice
            : true;
            let validPricePerNightTo = this.state.filter.maxprice
            ? room.pricePerNight <= +this.state.filter.maxprice
            : true;
            let validGuest = this.state.filter.guests
            ? room.guests >= +this.state.filter.guests
            : true;
            let validType = this.state.filter.type 
            ? room.roomtypesByFkRoomtypeId.id == this.state.filter.type 
            : true; 
            return (
                validPricePerNightFrom &&
                validPricePerNightTo &&
                validGuest &&
                validType
            );        
        });
        console.log('Objeto filter renderizado: ',this.state.filter);  /* objeto filter renderizado actual */
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
                        roomsFiltered.map((room) => (
                            <div className="row" key={room.id}> 
                                <Room image={require("assets/img/rooms/"+room.image)} id={room.id} name={room.roomtypesByFkRoomtypeId.name} pricePerNight={room.pricePerNight} guests={room.guests} description={room.description} booked={room.booked} startDate={this.state.filter.startDate} endDate={this.state.filter.endDate}/>                           
                            </div>    
                        ))
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