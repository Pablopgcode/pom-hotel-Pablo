package com.pomhotel.booking.ui.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class NewPriceDTO {

    //--- Attributes -----------------------------------------------
    @NotNull
    @NotEmpty
    public double lastPrice;

    @NotNull
    @NotEmpty
    public String message;

    //--- Getters & Setters ----------------------------------------
    public double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
