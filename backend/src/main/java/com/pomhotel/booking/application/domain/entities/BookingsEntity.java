package com.pomhotel.booking.application.domain.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

//--- Entity -------------------------------------------------------
@Entity
@Table(name = "bookings", schema = "pom_hotel")
public class BookingsEntity implements Serializable {

    //--- Attributes -----------------------------------------------
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Basic
    @Column(name = "checkIn", nullable = true)
    private Date checkIn;

    @Basic
    @Column(name = "checkOut", nullable = true)
    private Date checkOut;

    @Basic
    @Column(name = "totalPrice", nullable = true, precision = 0)
    private Double totalPrice;

    @ManyToOne
    @JoinColumn(name = "fk_client_id", referencedColumnName = "id", table = "bookings")
    private ClientsEntity clientsByFkClientId;

    @OneToOne
    @JoinColumn(name = "fk_room_id", referencedColumnName = "id", table = "bookings")
    private RoomsEntity roomsByFkRoomId;

    @Basic
    @Column(name = "safebox", nullable = true)
    private boolean safebox;

    @Basic
    @Column(name = "wedge", nullable = true)
    private boolean wedge;

    @Basic
    @Column(name = "laundry", nullable = true)
    private boolean laundry;

    @Basic
    @Column(name = "parking", nullable = true)
    private boolean parking;


    //--- Getters & Setters ---------------------------------------
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

    public ClientsEntity getClientsByFkClientId() {
        return clientsByFkClientId;
    }
    public void setClientsByFkClientId(ClientsEntity clientsByFkClientId) {
        this.clientsByFkClientId = clientsByFkClientId;
    }

    public RoomsEntity getRoomsByFkRoomId() {
        return roomsByFkRoomId;
    }
    public void setRoomsByFkRoomId(RoomsEntity roomsByFkRoomId) {
        this.roomsByFkRoomId = roomsByFkRoomId;
    }

    //--- Some general functions -----------------------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingsEntity that = (BookingsEntity) o;
        return id == that.id &&
                Objects.equals(checkIn, that.checkIn) &&
                Objects.equals(checkOut, that.checkOut) &&
                Objects.equals(totalPrice, that.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, checkIn, checkOut, totalPrice);
    }

}
