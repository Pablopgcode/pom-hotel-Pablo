package com.pomhotel.booking.application.models;

public class RoomsModel {
    public long id;
    public String code;
    public String description;
    public Double pricePerNight;
    public String image;
    public RoomtypesModel roomtypesByFkRoomtypeId;

    //Constructor
    public RoomsModel() {
    }
}
