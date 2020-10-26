import axios from 'axios';

const ROOMS_URL = "http://localhost:8080/boot";
class RoomService{
    getRooms(){
        return axios.get( ROOMS_URL + '/rooms');
    }
    
    getRoomsByPreferences(roomChoosed){
        // Objet with preferences
        roomChoosed = {
            checkin : "2020-10-10",
            checkout : "2020-10-10",
            guests : "2",
            minprice: '1',
            maxprice: '1000',
            type: '0'
        }
        // Request GET
        axios.get(( ROOMS_URL + '/rooms'), {
            params: roomChoosed
            }).then(response => {   
            this.room = response.data;
        }).catch(e => {
            console.log(e);
        })
    }
}
export default new RoomService()




