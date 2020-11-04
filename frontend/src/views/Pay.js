import React, { Component } from 'react';
import Header from 'components/Headers/Header.js';
import DarkFooter from "components/Footers/DarkFooter";
import Navbar from "components/Navbars/Navbar.js";
import FormConfirmation from 'components/Forms/FormConfirmation';
import RoomService from '../services/roomService.js';
import Detail from 'components/Detail.js';
class Pay extends Component {
    constructor(props) {
        super(props)
        this.state = {
            room: {},
            startDate: this.props.startDate,                            /* OJO AQUI !!!!! */
            endDate: this.props.endDate                                 /* NO VIENEN BIEN POR URL, MIRAR CHURRO EN COMPONENTE ROOM */
        }
    }
    
    componentDidMount(){
        let id = this.props.match.params.id; 
        RoomService.getRoomById(parseInt(id)).then((res) => {         
            this.setState({ room : res.data });
        });
    }
  
    render() {
        console.log('props: ', this.props);
        return (
            <React.Fragment>
                <Navbar />
                <Header image={require("assets/img/high-performance.jpg")} />
                {this.state.room.id ?  
                    <div className="row" key={this.state.room.id}>
                        <Detail image={require("assets/img/rooms/"+this.state.room.image)} id={this.state.room.id} type={this.state.room.roomtypesByFkRoomtypeId.name} price={this.state.room.pricePerNight} guests={this.state.room.guests} code={this.state.room.code} description={this.state.room.description}/>
                        <FormConfirmation startDate={this.startDate} endDate={this.endDate} /> 
                    </div>
                :<></>}    
                <DarkFooter />
            </React.Fragment>
        )
    }
}
export default Pay;