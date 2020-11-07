import axios from 'axios';
import { reduceEachLeadingCommentRange } from 'typescript';

const BOOKINGS_URL = "http://localhost:8080/boot";
class BookService{
    getBookings(){
        return axios.get( BOOKINGS_URL + '/booknow');
    }

    getTotalPrice(startDate, endDate, id){
        return axios.post(BOOKINGS_URL + '/getTotalPrice',{            
            checkIn: startDate,
            checkOut: endDate,
            roomId: id                      
        })
    }
}
export default new BookService

