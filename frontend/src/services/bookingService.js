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

    saveBooking(id, code, description, price, image, guests, roomtypesByFkRoomtypeId, startDate, endDate, totalPrice){
        return axios.post(BOOKINGS_URL + '/booknow',{
            roomId: id,
                room:{
                    id: id,
                    code: code,
                    description: description,
                    pricePerNight: price,
                    image: image,
                    guests: guests,
                    roomtypesByFkRoomtypeId: roomtypesByFkRoomtypeId
                },
            checkIn: startDate,
            checkOut: endDate,
            guests: guests,
            totalPrice: totalPrice
        })
    }
}

export default new BookService

