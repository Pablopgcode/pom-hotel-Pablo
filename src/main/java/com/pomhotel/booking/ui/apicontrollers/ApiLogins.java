package com.pomhotel.booking.ui.apicontrollers;

import com.pomhotel.booking.application.services.ClientLoginService;
import com.pomhotel.booking.ui.dto.NewClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
public class ApiLogins {

    //--- Services & Variables used ---------------------------------------
    ClientLoginService clientLoginService;

    //--- Constructor -----------------------------------------------------
    @Autowired
    void LoginController(ClientLoginService clientLoginService){
        this.clientLoginService = clientLoginService;
    }




}
