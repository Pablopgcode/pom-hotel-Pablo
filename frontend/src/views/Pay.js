import React, { Component } from 'react';
import Header from 'components/Headers/Header.js';
import DarkFooter from "components/Footers/DarkFooter";
import Navbar from "components/Navbars/Navbar.js";
import FormConfirmation from 'components/Forms/FormConfirmation';
import RoomService from '../services/roomService.js';
class Pay extends Component {
    constructor(props) {
        super(props)
        this.state = {
            room: {},
        }
    }
    
    componentDidMount(){
        let id = this.props.match.params.id;    
        RoomService.getRoomById(parseInt(id)).then((res) => {         
            this.setState({ room : res.data });
        });
    }
  
    render() {
        return (
            <React.Fragment>
                <Navbar />
                <Header image={require("assets/img/high-performance.jpg")} />
                {this.state.room.id ?  
                    <div className="row" key={this.state.room.id}>
                        <FormConfirmation image={require("assets/img/rooms/"+this.state.room.image)} id={this.state.room.id} type={this.state.room.roomtypesByFkRoomtypeId.name} price={this.state.room.pricePerNight} guests={this.state.room.guests} code={this.state.room.code} description={this.state.room.description}/>
                    </div>
                :<></>}    
                <DarkFooter />
            </React.Fragment>
        )
    }
}
export default Pay;