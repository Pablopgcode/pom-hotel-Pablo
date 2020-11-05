package com.pomhotel.booking.ui.rest;

import com.pomhotel.booking.application.models.BookingsModel;
import com.pomhotel.booking.application.models.ReservedModel;
import com.pomhotel.booking.application.models.RoomsModel;
import com.pomhotel.booking.application.services.BookingsService;
import com.pomhotel.booking.application.services.ClientLoginService;
import com.pomhotel.booking.application.services.RoomsService;
import com.pomhotel.booking.ui.controllers.SecurityController;
import com.pomhotel.booking.ui.dto.NewBookingDTO;
import com.pomhotel.booking.ui.dto.ReservedDatesDTO;
import com.pomhotel.booking.ui.servicies.BookingLogicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


@CrossOrigin (origins = "http://localhost:3000")
@RestController
@RequestMapping("/boot")
public class BookingRest {

    //--- Services & Variables used ---------------------------------------
    RoomsService roomsService;
    BookingsService bookingsService;
    ClientLoginService clientsService;
    SecurityController securityController;
    BookingLogicalService bookingLogicalService;
    RoomsModel roomSelected;

    //--- Constructor --------------------------------------------------
    @Autowired
    public BookingRest(RoomsService roomsService, BookingsService bookingsService, ClientLoginService clientsService, SecurityController securityController, BookingLogicalService bookingLogicalService) {
        this.roomsService = roomsService;
        this.bookingsService = bookingsService;
        this.clientsService = clientsService;
        this.securityController = securityController;
        this.bookingLogicalService = bookingLogicalService;
    }

    @GetMapping("/booknow")
    public List bookingsList(){
        List<BookingsModel> bookings = bookingsService.findAll();
        return bookings;
    }

    @GetMapping("/reserved/{id}")
    public List getReservedDatesByRoomId(@PathVariable long id){
        List <ReservedModel> reservedDates = bookingsService.getReservedDates(id);
        return reservedDates;
    }

    @GetMapping("/reser/{id}")
    public List getAlleDatum (@PathVariable long id){
        List <ReservedModel> reservedDates = bookingsService.getReservedDates(id);
        List<ReservedModel> allDatesReserved = new ArrayList<>();
        System.out.println(reservedDates.get(2).getCheckIn());
//        for (int i = 0; i < reservedDates.size(); i++) {
//            Date checkIn = reservedDates.get(i).getCheckIn();
//            Date checkOut = reservedDates.get(i).getCheckOut();
//            while (!checkIn.equals(checkOut)) {
//                allDatesReserved.add(checkIn);
//                checkIn = new Date(checkIn.getTime() + TimeUnit.DAYS.toMillis( 1 ));
//                System.out.println(allDatesReserved.toString());
//            }
//        }
        return reservedDates;
    }


    @GetMapping("/booknow/{id}")
    public BookingsModel  getBooking(@PathVariable long id) {
        BookingsModel model = bookingsService.findById(id);
        ResponseEntity<BookingsModel> response;
        if (model == null) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity<>(model, HttpStatus.OK);
        }
        return model;
    }

    @PostMapping("/booknow")
    public BookingsModel bookingnow(@RequestBody @Valid NewBookingDTO dto) {
        BookingsModel model = new BookingsModel();
        try {
            model.checkIn = bookingLogicalService.stringToDate(dto.checkIn);
            model.checkOut = bookingLogicalService.stringToDate(dto.checkOut);
            model.roomsByFKRoomId = roomsService.findById(dto.roomId);
            model.clientsByFkClientId = clientsService.findClientByUsername(securityController.currentUsername());
            model.totalPrice = bookingLogicalService.calculateTotalPrice(model.checkIn, model.checkOut, model.roomsByFKRoomId.pricePerNight);
            bookingsService.saveOrUpdate(model);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    @DeleteMapping("/booknow/{id}")
    public void deleteBooking(@PathVariable long id) {
        try {
            bookingsService.deleteById(id);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
