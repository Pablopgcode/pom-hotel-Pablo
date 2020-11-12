package com.pomhotel.booking.ui.servicies;

import org.springframework.stereotype.Service;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
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
    //-- Low Season 5% discount
    static final double LOW_SEASON_DISCOUNT = 0.05;
    //--- Functions ----------------------------------------------------
    @Override
    public double calculateTotalPrice(Date checkIn, Date checkOut, double pricePerNight, boolean safebox, boolean wedge, boolean laundry, boolean parking) {
        int [] offSesions = {0,1,2,3,4,5,9,10,11}; /* I consider high season July, August and September */
        boolean lowSeason = false;
        int month1 = getMonth(checkIn);
        int month2 = getMonth(checkOut);
        for(int i=0; i < offSesions.length; i++){
            if(offSesions[i] == month1 && offSesions[i] == month2){
                lowSeason = true;
            }
        }
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
        if (lowSeason){
            totalPrice -= (totalPrice * LOW_SEASON_DISCOUNT);
        }

        return totalPrice;
    }

    @Override
    public int getMonth(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH)+1;
        return month;
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
