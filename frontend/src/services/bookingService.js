import axios from 'axios';

const BOOKINGS_URL = "http://localhost:8080/boot";
class BookService{
    getBookings(){
        return axios.get( BOOKINGS_URL + '/booknow');
    }
}
export default new BookService()