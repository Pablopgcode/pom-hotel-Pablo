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
            startDate: this.props.location.state.data.startDate,                            
            endDate: this.props.location.state.data.endDate                               
        }
        console.log('Datos Room: ',props.location.state.data);
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
                        <FormConfirmation startDate={this.state.startDate} endDate={this.state.endDate} id={this.state.room.id} /> 
                    </div>
                :<></>}    
                <DarkFooter />
            </React.Fragment>
        )
    }
}
export default Pay;