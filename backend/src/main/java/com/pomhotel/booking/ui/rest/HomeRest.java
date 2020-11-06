package com.pomhotel.booking.ui.rest;

import com.pomhotel.booking.application.models.BookingsModel;
import com.pomhotel.booking.application.models.RoomsModel;
import com.pomhotel.booking.application.models.RoomtypesModel;
import com.pomhotel.booking.application.services.BookingsService;
import com.pomhotel.booking.application.services.RoomTypesService;
import com.pomhotel.booking.application.services.RoomsService;
import com.pomhotel.booking.ui.dto.SearchDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@CrossOrigin (origins = "http://localhost:3000")
@RestController
@RequestMapping("boot")
public class HomeRest {

    //--- Services & Variables used ---------------------------------------
    RoomsService roomsService;
    RoomTypesService roomTypesService;
    BookingsService bookingsService;

    //--- Constructor -----------------------------------------------------
    @Autowired
    public HomeRest(RoomsService roomsService, RoomTypesService roomTypesService, BookingsService bookingsService) {
        this.roomsService = roomsService;
        this.roomTypesService = roomTypesService;
        this.bookingsService = bookingsService;
    }

    //--- Rooms Mappings -----------------------------------------------------
    @GetMapping("/rooms")
    public List roomsList(){
        List<RoomsModel> rooms = roomsService.findAll();
        for (RoomsModel room : rooms){
            room.setBooked(bookingsService.getReservedDates(room.id));
        }
        return rooms;
    }

    @GetMapping("/rooms/{id}")
    public RoomsModel getRoomsById(@PathVariable long id) {
        RoomsModel model = roomsService.findById(id);
        ResponseEntity<RoomsModel> response;
        if (model == null) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity<>(model, HttpStatus.OK);
        }
        return model;
    }

    @GetMapping("/types")
    public List roomsTypes(){
        List<RoomtypesModel> types = roomTypesService.findAll();
        return types;
    }


    @PostMapping("/rooms")
    public List<RoomsModel> apirooms(@RequestBody SearchDTO dto) {
        if ( ( dto.minprice==null) && (dto.maxprice==null) && (dto.type==null) ) {
            dto.minprice = "1";
            dto.maxprice = "1000";
            dto.type = "0";
        }
        List<RoomsModel> rooms = roomsService.findApplyingFilter(Integer.parseInt(dto.guests),Integer.parseInt(dto.minprice),Integer.parseInt(dto.maxprice), Long.parseLong(dto.type));
        return rooms;
    }
}


