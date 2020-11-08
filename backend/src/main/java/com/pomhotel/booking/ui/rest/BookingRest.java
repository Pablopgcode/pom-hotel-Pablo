package com.pomhotel.booking.ui.rest;

import com.pomhotel.booking.application.models.BookingsModel;
import com.pomhotel.booking.application.models.RoomsModel;
import com.pomhotel.booking.application.services.BookingsService;
import com.pomhotel.booking.application.services.ClientLoginService;
import com.pomhotel.booking.application.services.RoomsService;
import com.pomhotel.booking.ui.dto.NewBookingDTO;
import com.pomhotel.booking.ui.dto.NewCalculTotalDTO;
import com.pomhotel.booking.ui.servicies.BookingLogicalService;
import com.pomhotel.booking.ui.servicies.BookingLogicalServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.sql.Date;
import java.util.List;


@CrossOrigin (origins = "http://localhost:3000")
@RestController
@RequestMapping("/boot")
public class BookingRest {

    //--- Services & Variables used ---------------------------------------
    RoomsService roomsService;
    BookingsService bookingsService;
    ClientLoginService clientsService;
    BookingLogicalService bookingLogicalService;
    RoomsModel roomSelected;

    //--- Constructor --------------------------------------------------
    @Autowired
    public BookingRest(RoomsService roomsService, BookingsService bookingsService, ClientLoginService clientsService, BookingLogicalService bookingLogicalService) {
        this.roomsService = roomsService;
        this.bookingsService = bookingsService;
        this.clientsService = clientsService;
        this.bookingLogicalService = bookingLogicalService;
    }

    @GetMapping("/bookings")
    public List bookingsList(){
        List<BookingsModel> bookings = bookingsService.findAll();
        return bookings;
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

    @PostMapping("/getTotalPrice")
    public Double getTotalPrice(@RequestBody @Valid NewCalculTotalDTO dto){
        Double totalPrice = 0.0;
        try{
            RoomsModel model = roomsService.findById(dto.roomId);
            totalPrice = bookingLogicalService.calculateTotalPrice(dto.checkIn, dto.checkOut, model.pricePerNight);
        }catch (Exception e){
            e.printStackTrace();
        }
        return totalPrice;
    }


    @PostMapping("/booknow")
    public long bookingnow(@RequestBody @Valid NewBookingDTO dto) {
        BookingsModel model = new BookingsModel();
        long id = 0;
        try {
            model.checkIn = Date.valueOf(dto.checkIn);
            model.checkOut = Date.valueOf(dto.checkOut);
            model.roomsByFKRoomId = roomsService.findById(dto.roomId);
            model.clientsByFkClientId = clientsService.findClientByUsername("Garcia1989");
            model.totalPrice = bookingLogicalService.calculateTotalPrice(model.checkIn, model.checkOut, model.roomsByFKRoomId.pricePerNight);
            id = bookingsService.saveOrUpdate(model);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return id;
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
