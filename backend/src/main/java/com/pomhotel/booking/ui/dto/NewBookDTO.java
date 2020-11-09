package com.pomhotel.booking.ui.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

//--- DTO ----------------------------------------------------------
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

    @NotNull
    @NotEmpty
    public boolean safebox;

    @NotNull
    @NotEmpty
    public boolean wedge;

    @NotNull
    @NotEmpty
    public boolean laundry;

    @NotNull
    @NotEmpty
    public boolean parking;

    //--- Getters & Setters ----------------------------------------
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

    public boolean isSafebox() {
        return safebox;
    }

    public void setSafebox(boolean safebox) {
        this.safebox = safebox;
    }

    public boolean isWedge() {
        return wedge;
    }

    public void setWedge(boolean wedge) {
        this.wedge = wedge;
    }

    public boolean isLaundry() {
        return laundry;
    }

    public void setLaundry(boolean laundry) {
        this.laundry = laundry;
    }

    public boolean isParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }
}
