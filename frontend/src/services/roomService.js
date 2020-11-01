import axios from 'axios';
const ROOMS_URL = "http://localhost:8080/boot";
class RoomService{
    getRooms(){
        return axios.get( ROOMS_URL + '/rooms');
    }

    getRoomById(id){
        return axios.get(ROOMS_URL + '/rooms/' + id);
    }

    

    

    

}
export default new RoomService()




