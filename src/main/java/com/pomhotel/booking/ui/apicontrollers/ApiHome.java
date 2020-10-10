package com.pomhotel.booking.ui.apicontrollers;

import com.pomhotel.booking.application.models.RoomsModel;
import com.pomhotel.booking.application.models.RoomtypesModel;
import com.pomhotel.booking.application.services.RoomTypesService;
import com.pomhotel.booking.application.services.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ApiHome {

    //--- Services & Variables used ---------------------------------------
    RoomsService roomsService;
    RoomTypesService roomTypesService;

    //--- Constructor -----------------------------------------------------
    @Autowired
    public ApiHome(RoomsService roomsService, RoomTypesService roomTypesService) {
        this.roomsService = roomsService;
        this.roomTypesService = roomTypesService;
    }

    //--- Rooms Mappings -----------------------------------------------------
    @GetMapping("/apirooms")
    public List roomsList(){
        List<RoomsModel> rooms = roomsService.findAll();
        return rooms;
    }

    //--- RoomsType Mappings -----------------------------------------------------
    @GetMapping("/apitypes")
    public List roomsTypes(){
        List<RoomtypesModel> types = roomTypesService.findAll();
        return types;
    }


    //@PostMapping("/apirooms")


}


