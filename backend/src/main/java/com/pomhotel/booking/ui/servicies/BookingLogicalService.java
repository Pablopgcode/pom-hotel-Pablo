package com.pomhotel.booking.ui.servicies;


import com.pomhotel.booking.ui.dto.NewPriceDTO;
import java.sql.Date;

//--- Service Interface -------------------------------------------
public interface BookingLogicalService {

    long getDaysBetweenTwoDates(Date date1, Date date2);

    Date stringToDate(String date);

    public int getMonth(Date date);

    NewPriceDTO calculateTotalPrice(Date checkIn, Date CheckOut, double pricePerNight, boolean safebox, boolean wedge, boolean laundry, boolean parking);

}
