import axios from 'axios';
const BOOT_URL = "http://localhost:8080/boot";

class OffersService{
    getOffers(){
        return axios.get( BOOT_URL + '/offers');
    }
}
export default new OffersService()
