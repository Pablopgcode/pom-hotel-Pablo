package com.pomhotel.booking.ui.apicontrollers;

import com.pomhotel.booking.application.models.RoomsModel;
import com.pomhotel.booking.application.services.BookingsService;
import com.pomhotel.booking.application.services.ClientLoginService;
import com.pomhotel.booking.application.services.RoomsService;
import com.pomhotel.booking.ui.controllers.SecurityController;
import com.pomhotel.booking.ui.dto.NewBookingDTO;
import com.pomhotel.booking.ui.servicies.BookingLogicalService;
import com.pomhotel.booking.ui.servicies.BookingLogicalServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
public class ApiBookings {

    //--- Services & Variables used ---------------------------------------
    RoomsService roomsService;
    BookingsService bookingsService;
    ClientLoginService clientsService;
    SecurityController securityController;
    BookingLogicalService bookingLogicalService;
    RoomsModel roomSelected;

    //--- Constructor --------------------------------------------------
    @Autowired
    public ApiBookings(RoomsService roomsService, BookingsService bookingsService, ClientLoginService clientsService, SecurityController securityController, BookingLogicalService bookingLogicalService) {
        this.roomsService = roomsService;
        this.bookingsService = bookingsService;
        this.clientsService = clientsService;
        this.securityController = securityController;
        this.bookingLogicalService = bookingLogicalService;
    }

    @GetMapping("/bookingnow/{id}")
    public RoomsModel bookroomnow(@PathVariable("id") long id, @CookieValue("Checkin") String checkin,@CookieValue("Checkout") String checkout, Model model) {
        BookingLogicalService calculadora = new BookingLogicalServiceImplementation();
        roomSelected = roomsService.findById(id);
        NewBookingDTO newBookingDTO = new NewBookingDTO();
        newBookingDTO.room = roomSelected;
        newBookingDTO.checkIn = checkin;
        newBookingDTO.checkOut = checkout;
        newBookingDTO.totalPrice = (int) calculadora.calculateTotalPrice(calculadora.stringToDate(checkin),calculadora.stringToDate(checkout),roomSelected.pricePerNight);
        return roomSelected;
    }


    // @PostMapping("/bookingnow")


}
