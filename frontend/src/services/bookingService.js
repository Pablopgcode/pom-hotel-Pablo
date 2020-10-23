import axios from 'axios';

const BOOKINGS_URL = "http://localhost:8080/boot";
class BookService{
    getReservas(){
        return axios.get( BOOKINGS_URL + '/booknow');
    }
    /*getFechasReservaHabitacion(id){
        return axios.get( RESERVA_API_BASE_URL + '/date/' + id);
    }*/
}
export default new BookService()