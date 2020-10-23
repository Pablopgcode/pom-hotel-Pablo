import React, { Component } from 'react';
import BookService from '../services/bookingService.js'

class ListBookingComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            reservas: []
        }
    }
    componentDidMount(){
        BookService.getReservas().then((res) => {
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
                            <th>Fecha In</th>
                            <th>Fecha Out </th>
                            <th>Precio</th>
                            <th>Cliente</th>
                        </tr>
                    </thead>
                    <tbody>
                                {
                                    this.state.reservas.map(
                                        books => 
                                        <tr key = {books.id}>
                                             <td> {books.checkIn} </td>   
                                             <td> {books.checkOut}</td>
                                             <td> {books.totalPrice}</td>
                                             <td> {books.clientsByFkClientId.email}</td>                            
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
export default ListBookingComponent