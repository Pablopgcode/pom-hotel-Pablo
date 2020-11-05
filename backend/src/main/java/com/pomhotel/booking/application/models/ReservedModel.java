package com.pomhotel.booking.application.models;

import java.sql.Date;

public class ReservedModel {
    public Date checkIn;
    public Date checkOut;

    public ReservedModel(Date checkIn, Date checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public ReservedModel() {
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

    @Override
    public String toString() {
        return "ReservedModel{" +
                "checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                '}';
    }
}
