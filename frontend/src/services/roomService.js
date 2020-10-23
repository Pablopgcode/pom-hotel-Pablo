import axios from 'axios';

const ROOMS_URL = "http://localhost:8080/boot";
class RoomService{
    getRooms(){
        return axios.get( ROOMS_URL + '/rooms');
    }   
}
export default new RoomService()