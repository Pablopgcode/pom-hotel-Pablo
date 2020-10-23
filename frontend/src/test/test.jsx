import React, { Component } from 'react';
import ReservaService from '../services/bookingService.js'

class ListReservaComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            reservas: []
        }
    }
    componentDidMount(){
        ReservaService.getReservas().then((res) => {
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
                                        reservas => 
                                        <tr key = {reservas.id}>
                                             <td> {reservas.checkIn} </td>   
                                             <td> {reservas.checkOut}</td>
                                             <td> {reservas.totalPrice}</td>
                                             <td> {reservas.clientsByFkClientId.email}</td>                            
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
export default ListReservaComponent