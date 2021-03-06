package com.pomhotel.booking.ui.apicontrollers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiSecurity {

    public class SecurityController {

        //--- Functions ----------------------------------------------------
        public String currentUsername() {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
                return ((UserDetails)principal).getUsername();
            } else {
                return principal.toString();
            }
        }
    }
}
