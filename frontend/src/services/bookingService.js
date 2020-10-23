import axios from 'axios';

const RESERVA_API_BASE_URL = "http://localhost:8080/boot";
class ReservaService{
    getReservas(){
        return axios.get( RESERVA_API_BASE_URL + '/booknow');
    }
    /*getFechasReservaHabitacion(id){
        return axios.get( RESERVA_API_BASE_URL + '/date/' + id);
    }*/
}
export default new ReservaService()