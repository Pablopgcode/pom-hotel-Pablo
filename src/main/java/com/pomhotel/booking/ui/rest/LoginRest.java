package com.pomhotel.booking.ui.rest;

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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

//--- Controller ----------------------------------------------------------
@RestController
@RequestMapping("rest")
public class LoginRest {

    //--- Services & Variables used ---------------------------------------
    ClientLoginService clientLoginService;

    //--- Constructor -----------------------------------------------------
    @Autowired
    LoginRest(ClientLoginService clientLoginService){
        this.clientLoginService = clientLoginService;
    }


    //--- Sign In & Log Out Mappings --------------------------------------
    @GetMapping("/restlogin")   //// NI IDEA
    public NewClientDTO signIn(WebRequest request, Model model){
        NewClientDTO newclient = new NewClientDTO();
        return newclient;
    }

    /*@GetMapping(value="/restlogout")   /// NI IDEA
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return "redirect:/signin?logout";
    }

    //--- Register New Client Mapping --------------------------------------
    @PostMapping("/registernewclient")
    public String registerNewClient(@ModelAttribute("newclient") @Valid NewClientDTO newclient, HttpServletRequest request, Errors errors) {
        ClientsModel clientModel = new ClientsModel(newclient.name, newclient.lastname, newclient.email);
        LoginsModel loginModel = new LoginsModel(newclient.username, newclient.password, clientModel);
        clientLoginService.createClientAndLogin(loginModel);

        if (true) {
            return "redirect:/home";
        } else {
            return "registerfail";
        }
    }*/
}
