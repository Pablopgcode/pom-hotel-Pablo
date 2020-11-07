package com.pomhotel.booking.ui.dto;

import com.pomhotel.booking.application.models.RoomsModel;

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
}
