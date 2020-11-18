package com.pomhotel.booking.ui.rest;

import com.pomhotel.booking.application.models.OffersModel;
import com.pomhotel.booking.application.services.OffersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("boot")
public class OffersRest {

    //--- Services & Variables used ---------------------------------------
    OffersService offersService;

    //--- Constructor -----------------------------------------------------
    @Autowired
    public OffersRest(OffersService offersService) {
        this.offersService = offersService;
    }

    //--- Offers Mappings -----------------------------------------------------
    @GetMapping("/offers")
    public List offersList(){
        List<OffersModel> offers = offersService.findAll();
        return offers;
    }
}
