package com.pomhotel.booking.ui.apicontrollers;

import com.pomhotel.booking.application.models.ClientsModel;
import com.pomhotel.booking.application.models.LoginsModel;
import com.pomhotel.booking.application.services.ClientLoginService;
import com.pomhotel.booking.ui.dto.NewClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

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
