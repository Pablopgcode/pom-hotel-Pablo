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

    saveBooking(id, startDate, endDate, totalPrice, safebox, wedge, laundry, parking){
        return axios.post(BOOKINGS_URL + '/booknow',{
            roomId: id,
            checkIn: startDate,
            checkOut: endDate,
            totalPrice: totalPrice,
            safebox: safebox,
            wedge: wedge,
            laundry: parking
        })
    }
}

export default new BookService

