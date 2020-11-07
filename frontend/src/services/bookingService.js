import axios from 'axios';
import { reduceEachLeadingCommentRange } from 'typescript';

const BOOKINGS_URL = "http://localhost:8080/boot";
class BookService{
    getBookings(){
        return axios.get( BOOKINGS_URL + '/booknow');
    }

    getTotalPrice(startDate, endDate, id){
        axios.post(BOOKINGS_URL + '/getTotalPrice',{            
                checkIn: startDate,
                checkOut: endDate,
                roomId: id                      
        })
        .then(function(res){
            if(res.status == 201){
                return res.data;
                console.log(res.data);
            }
        })
        .catch(function(err){
            console.log(err);
        })
    }
}
export default new BookService

