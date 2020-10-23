package com.pomhotel.booking.ui.rest;

import com.pomhotel.booking.application.models.RoomsModel;
import com.pomhotel.booking.application.services.RoomTypesService;
import com.pomhotel.booking.application.services.RoomsService;
import com.pomhotel.booking.ui.dto.SearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin (origins = "http://localhost:3000")
@RestController
@RequestMapping("boot")
public class HomeRest {

    //--- Services & Variables used ---------------------------------------
    RoomsService roomsService;
    RoomTypesService roomTypesService;

    //--- Constructor -----------------------------------------------------
    @Autowired
    public HomeRest(RoomsService roomsService, RoomTypesService roomTypesService) {
        this.roomsService = roomsService;
        this.roomTypesService = roomTypesService;
    }

    //--- Rooms Mappings -----------------------------------------------------
    @GetMapping("/rooms")
    public List roomsList(){
        List<RoomsModel> rooms = roomsService.findAll();
        return rooms;
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


