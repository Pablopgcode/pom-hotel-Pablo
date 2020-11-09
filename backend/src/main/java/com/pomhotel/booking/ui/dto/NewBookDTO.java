package com.pomhotel.booking.ui.dto;

import com.pomhotel.booking.application.models.RoomsModel;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class NewBookDTO {

    //--- Attributes -----------------------------------------------
    @NotNull
    @NotEmpty
    public long roomId;


    @NotNull
    @NotEmpty
    public String checkIn;


    @NotNull
    @NotEmpty
    public String checkOut;

    @NotNull
    @NotEmpty
    public long clientsByFkClientId;

    @NotNull
    @NotEmpty
    public int totalPrice;

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public long getClientsByFkClientId() {
        return clientsByFkClientId;
    }

    public void setClientsByFkClientId(long clientsByFkClientId) {
        this.clientsByFkClientId = clientsByFkClientId;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
