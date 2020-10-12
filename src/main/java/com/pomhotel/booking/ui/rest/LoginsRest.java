package com.pomhotel.booking.ui.rest;

import com.pomhotel.booking.application.services.ClientLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginsRest {

    //--- Services & Variables used ---------------------------------------
    ClientLoginService clientLoginService;

    //--- Constructor -----------------------------------------------------
    @Autowired
    void LoginController(ClientLoginService clientLoginService){
        this.clientLoginService = clientLoginService;
    }




}
