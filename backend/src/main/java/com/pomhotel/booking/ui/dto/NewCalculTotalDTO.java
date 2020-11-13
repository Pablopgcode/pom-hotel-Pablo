package com.pomhotel.booking.ui.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;


public class NewCalculTotalDTO {

    //--- Attributes -----------------------------------------------
    @NotNull
    @NotEmpty
    public long roomId;

    @NotNull
    @NotEmpty
    public Date checkIn;

    @NotNull
    @NotEmpty
    public Date checkOut;

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


    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
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
