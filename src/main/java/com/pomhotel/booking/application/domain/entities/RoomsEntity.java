package com.pomhotel.booking.application.domain.entities;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "rooms", schema = "pom_hotel", catalog = "")
public class RoomsEntity {
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Basic
    @Column(name = "code", nullable = true, length = 100)
    private String code;

    @Basic
    @Column(name = "description", nullable = true, length = 200)
    private String description;

    @Basic
    @Column(name = "pricePerNight", nullable = true, precision = 0)
    private Double pricePerNight;

    @Basic
    @Column(name = "image", nullable = true)
    private byte[] image;

    @OneToMany(mappedBy = "roomsByFkRoomId")
    private Collection<BookingsEntity> bookingsById;

    @ManyToOne
    @JoinColumn(name = "fk_roomtype_id", referencedColumnName = "id", table = "rooms")
    private RoomtypesEntity roomtypesByFkRoomtypeId;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPricePerNight() {
        return pricePerNight;
    }
    public void setPricePerNight(Double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public byte[] getImage() {
        return image;
    }
    public void setImage(byte[] image) {
        this.image = image;
    }

    public Collection<BookingsEntity> getBookingsById() {
        return bookingsById;
    }
    public void setBookingsById(Collection<BookingsEntity> bookingsById) {
        this.bookingsById = bookingsById;
    }

    public RoomtypesEntity getRoomtypesByFkRoomtypeId() {
        return roomtypesByFkRoomtypeId;
    }
    public void setRoomtypesByFkRoomtypeId(RoomtypesEntity roomtypesByFkRoomtypeId) {
        this.roomtypesByFkRoomtypeId = roomtypesByFkRoomtypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomsEntity that = (RoomsEntity) o;
        return id == that.id &&
                Objects.equals(code, that.code) &&
                Objects.equals(description, that.description) &&
                Objects.equals(pricePerNight, that.pricePerNight) &&
                Arrays.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, code, description, pricePerNight);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }
}
