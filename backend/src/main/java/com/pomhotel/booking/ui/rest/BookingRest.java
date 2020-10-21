package com.pomhotel.booking.ui.rest;

import com.pomhotel.booking.application.domain.entities.BookingsEntity;
import com.pomhotel.booking.application.models.BookingsModel;
import com.pomhotel.booking.application.models.RoomsModel;
import com.pomhotel.booking.application.services.BookingsService;
import com.pomhotel.booking.application.services.ClientLoginService;
import com.pomhotel.booking.application.services.RoomsService;
import com.pomhotel.booking.ui.controllers.SecurityController;
import com.pomhotel.booking.ui.dto.NewBookingDTO;
import com.pomhotel.booking.ui.dto.SearchDTO;
import com.pomhotel.booking.ui.servicies.BookingLogicalService;
import com.pomhotel.booking.ui.servicies.BookingLogicalServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("rest")
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

    @GetMapping("/bookingnow/{id}")
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

    @PostMapping("/bookingnow")
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

    @DeleteMapping("/bookingnow/{id}")
    public void deleteBooking(@PathVariable long id) {
        try {
            bookingsService.deleteById(id);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PutMapping("/bookingnow/{id}")
    public BookingsModel updateBooking(@RequestBody @Valid NewBookingDTO dto) {
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

}
