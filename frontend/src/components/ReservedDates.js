import BookService from 'services/bookingService.js';
import React, { Component } from 'react';
class ReservedDates extends Component {
    constructor(props) {
        super(props)
        this.state = {
            reservas: []
        }
    }
    componentDidMount(){
        BookService.getBookings().then((res) => {
            this.setState({ reservas : res.data });
        });
    }
    render() {
        return (
            <div>
                <h2 className = "text-center">Lista de Reservas SPRING + REACT</h2>
                <div className = "Row" >
                    <table className = "table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>Cliente</th>
                            <th>Habitación Id</th>
                            <th>Fecha In</th>
                            <th>Fecha Out </th>
                            <th>Precio</th>
                            
                        </tr>
                    </thead>
                    <tbody>
                                {
                                    this.state.reservas.map(
                                        reservas => 
                                        <tr key = {reservas.id}>
                                             <td>{reservas.clientsByFkClientId.id}</td>
                                             <td>{reservas.roomsByFKRoomId.id}</td>
                                             <td> {reservas.checkIn} </td>   
                                             <td> {reservas.checkOut}</td>
                                             <td> {reservas.totalPrice}</td>
                                                                        
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
export default ReservedDates