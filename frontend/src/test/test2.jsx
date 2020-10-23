import React, { Component } from 'react';
import RoomService from '../services/roomService.js'

class ListRoomComponent extends Component {
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
            <div>
                <h2 className = "text-center">Lista de Habitaciones SPRING + REACT</h2>
                <div className = "Row" >
                    <table className = "table table-striped table-bordered">
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
                                        <tr key = {room.id}>
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
            </div>
        )
    }
}
export default ListRoomComponent