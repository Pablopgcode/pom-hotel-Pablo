package com.pomhotel.booking.ui.dto;

import com.pomhotel.booking.application.models.ReservedModel;
import com.pomhotel.booking.application.services.BookingsService;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ReservedDatesDTO {

    BookingsService bookingService;

    public ReservedDatesDTO(BookingsService bookingService) {
        this.bookingService = bookingService;
    }

    public List reservedDates(long id){
        List <ReservedModel> reservedDates = bookingService.getReservedDates(id);
        List<Date> allDatesReserved = new ArrayList<>();
        for (int i = 0; i < reservedDates.size(); i++) {
            Date checkIn = reservedDates.get(i).getCheckIn();
            Date checkOut = reservedDates.get(i).getCheckOut();
            while (!checkIn.equals(checkOut)) {
                allDatesReserved.add(checkIn);
                checkIn = new Date(checkIn.getTime() + TimeUnit.DAYS.toMillis( 1 ));
                System.out.println(allDatesReserved.toString());
            }
        }
        return allDatesReserved;
    }
}
