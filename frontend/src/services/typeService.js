import axios from 'axios';

const BOOKINGS_URL = "http://localhost:8080/boot";
class TypeService{
    getTypes(){
        return axios.get( BOOKINGS_URL + '/types');
    }
}
export default new TypeService()