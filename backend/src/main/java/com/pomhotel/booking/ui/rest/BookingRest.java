package com.pomhotel.booking.ui.rest;

import com.pomhotel.booking.application.models.BookingsModel;
import com.pomhotel.booking.application.models.RoomsModel;
import com.pomhotel.booking.application.services.BookingsService;
import com.pomhotel.booking.application.services.ClientLoginService;
import com.pomhotel.booking.application.services.RoomsService;
import com.pomhotel.booking.ui.dto.NewBookDTO;
import com.pomhotel.booking.ui.dto.NewCalculTotalDTO;
import com.pomhotel.booking.ui.dto.NewPriceDTO;
import com.pomhotel.booking.ui.servicies.BookingLogicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


    @RequestMapping(value="/getTotalPrice", method=RequestMethod.POST, produces="application/json")
    //public ResponseEntity<NewPriceDTO> getTotalPrice(@RequestBody @Valid NewCalculTotalDTO dto){
    public NewPriceDTO getTotalPrice(@RequestBody @Valid NewCalculTotalDTO dto){
        NewPriceDTO newPrice = new NewPriceDTO();
        try{
            RoomsModel model = roomsService.findById(dto.roomId);
            newPrice = bookingLogicalService.calculateTotalPrice(dto.checkIn, dto.checkOut, model.pricePerNight, dto.safebox, dto.wedge, dto.laundry, dto.parking);
        }catch (Exception e){
            e.printStackTrace();
        }
        //return new ResponseEntity(newPrice, HttpStatus.ACCEPTED);
        return newPrice;

    }

    @PostMapping("/booknow")
    public long bookingnow(@RequestBody @Valid NewBookDTO dto) {
        BookingsModel model = new BookingsModel();
        RoomsModel room = roomsService.findById(dto.roomId);
        long id = 0;

        try {
            NewPriceDTO newPrice = bookingLogicalService.calculateTotalPrice(Date.valueOf(dto.checkIn), Date.valueOf(dto.checkOut), room.pricePerNight, dto.safebox, dto.wedge, dto.laundry, dto.parking);
            model.checkIn = Date.valueOf(dto.checkIn);
            model.checkOut = Date.valueOf(dto.checkOut);
            model.roomsByFKRoomId = room;
            model.clientsByFkClientId = clientsService.findClientByUsername("Garcia1989");
            model.safebox = dto.safebox;
            model.wedge = dto.wedge;
            model.laundry = dto.laundry;
            model.parking = dto.parking;
            model.totalPrice = newPrice.getLastPrice();
            id = bookingsService.saveOrUpdate(model);

        }catch (Exception e) {
            e.printStackTrace();
        }
            return id;
    }
}
