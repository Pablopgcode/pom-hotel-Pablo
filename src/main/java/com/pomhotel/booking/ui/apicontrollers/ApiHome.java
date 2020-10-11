package com.pomhotel.booking.ui.apicontrollers;

import com.pomhotel.booking.application.models.BookingsModel;
import com.pomhotel.booking.application.models.RoomsModel;
import com.pomhotel.booking.application.models.RoomtypesModel;
import com.pomhotel.booking.application.services.RoomTypesService;
import com.pomhotel.booking.application.services.RoomsService;
import com.pomhotel.booking.ui.dto.SearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @GetMapping("/apicontrollers/apirooms")
    public List roomsList(){
        List<RoomsModel> rooms = roomsService.findAll();
        return rooms;
    }

    //--- RoomsType Mappings -----------------------------------------------------
    @GetMapping("/apicontrollers/apitypes")
    public List roomsTypes(){
        List<RoomtypesModel> types = roomTypesService.findAll();
        return types;
    }


    @PostMapping("/apicontrollers/apirooms")  // ???????????????????????????????
    public List<RoomsModel> apirooms(@RequestBody SearchDTO dto) {
        System.out.println("apirooms: " + dto.toString());
        if ( ( dto.minprice==null) && (dto.maxprice==null) && (dto.type==null) ) {
            dto.minprice = "1";
            dto.maxprice = "1000";
            dto.type = "0";
        }
        List<RoomsModel> rooms = roomsService.findApplyingFilter(Integer.parseInt(dto.guests),Integer.parseInt(dto.minprice),Integer.parseInt(dto.maxprice), Long.parseLong(dto.type));
        return rooms;
    }
}


