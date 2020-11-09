package com.pomhotel.booking.ui.servicies;

import org.springframework.stereotype.Service;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

//--- Service ----------------------------------------------------------
@Service
public class BookingLogicalServiceImplementation implements BookingLogicalService {
    DateTimeFormatter formatoDeEntrada = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    DateTimeFormatter formatoDeSalida = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    //-- Optional Hotel Services
    static final int SAFEBOX_DAY = 12;
    static final int WEDGE_DAY = 5;
    static final int LAUNDRY_DAY = 7;
    static final int PARKING_DAY = 14;

    //--- Functions ----------------------------------------------------
    @Override
    public double calculateTotalPrice(Date checkIn, Date checkOut, double pricePerNight, boolean safebox, boolean wedge, boolean laundry, boolean parking) {
        long nights = getDaysBetweenTwoDates(checkIn, checkOut);
        long optionals = 0;
        if(safebox){
            optionals += SAFEBOX_DAY;
        }
        if(wedge){
            optionals += WEDGE_DAY;
        }
        if(laundry){
            optionals += LAUNDRY_DAY;
        }
        if(parking){
            optionals += PARKING_DAY;
        }
        double totalPrice = nights * (pricePerNight + optionals);
        return totalPrice;
    }

    @Override
    public Date stringToDate(String date) {
        return Date.valueOf( LocalDate.parse(date, formatoDeEntrada).format(formatoDeSalida) );
    }


    @Override
    public long getDaysBetweenTwoDates(Date date1, Date date2) {
        return TimeUnit.DAYS.convert((date2.getTime() - date1.getTime()), TimeUnit.MILLISECONDS);
    }

}
