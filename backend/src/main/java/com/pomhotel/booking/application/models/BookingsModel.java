package com.pomhotel.booking.application.models;

import java.sql.Date;


//--- Model --------------------------------------------------------
public class BookingsModel {

    //--- Attributes -----------------------------------------------
    public long id;
    public Date checkIn;
    public Date checkOut;
    public Double totalPrice;
    public ClientsModel clientsByFkClientId;
    public RoomsModel roomsByFKRoomId;
    public boolean safebox;
    public boolean wedge;
    public boolean laundry;
    public boolean parking;
    //--- Constructor ----------------------------------------------

    public BookingsModel(long id, Date checkIn, Date checkOut, Double totalPrice, ClientsModel clientsByFkClientId, RoomsModel roomsByFKRoomId, boolean safebox, boolean wedge, boolean laundry, boolean parking) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.totalPrice = totalPrice;
        this.clientsByFkClientId = clientsByFkClientId;
        this.roomsByFKRoomId = roomsByFKRoomId;
        this.safebox = safebox;
        this.wedge = wedge;
        this.laundry = laundry;
        this.parking = parking;
    }

    public BookingsModel() {
    }


    //--- Getters & Setters ----------------------------------------
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
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

    public Double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ClientsModel getClientsByFkClientId() {
        return clientsByFkClientId;
    }
    public void setClientsByFkClientId(ClientsModel clientsByFkClientId) {
        this.clientsByFkClientId = clientsByFkClientId;
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

    public RoomsModel getRoomsByFKRoomId() {
        return roomsByFKRoomId;
    }
    public void setRoomsByFKRoomId(RoomsModel roomsByFKRoomId) {
        this.roomsByFKRoomId = roomsByFKRoomId;
    }

    @Override
    public String toString() {
        return "BookingsModel{" +
                "id=" + id +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", totalPrice=" + totalPrice +
                ", clientsByFkClientId=" + clientsByFkClientId +
                ", roomsByFKRoomId=" + roomsByFKRoomId +
                ", safebox=" + safebox +
                ", wedge=" + wedge +
                ", laundry=" + laundry +
                ", parking=" + parking +
                '}';
    }
}
