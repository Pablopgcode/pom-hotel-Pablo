import React, { Component } from 'react';
import Header from 'components/Headers/Header.js';
import Navbar from "components/Navbars/Navbar.js";
import DarkFooter from "components/Footers/DarkFooter";
import RoomService from '../services/roomService.js';

class Booknow extends Component {
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
        return(

        <React.Fragment>
            <Navbar />
            <Header image={require("assets/img/bg6.jpg")}/>


            <div className="Row" >
                <table className="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>CODE</th>
                            <th>NAME</th>
                            <th>DESCRIPTION</th>
                            <th>PRICE NIGHT</th>
                            <th>GUESTS</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.rooms.map(
                                room =>
                                    <tr key={room.id}>
                                        <td> {room.code} </td>
                                        {<td> {room.roomtypesByFkRoomtypeId.name}</td>}
                                        <td> {room.description}</td>
                                        <td> {room.pricePerNight}</td>
                                        <td> {room.guests}</td>
                                    </tr>
                            )
                        }
                    </tbody>
                </table>
            </div>









            <DarkFooter />
        </React.Fragment>
        )
    }
}
export default Booknow;