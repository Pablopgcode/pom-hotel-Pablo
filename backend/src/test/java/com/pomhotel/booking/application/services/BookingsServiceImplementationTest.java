package com.pomhotel.booking.application.services;

import com.pomhotel.booking.application.models.BookingsModel;
import com.pomhotel.booking.application.models.ClientsModel;
import com.pomhotel.booking.application.models.RoomsModel;
import com.pomhotel.booking.application.models.RoomtypesModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BookingsServiceImplementationTest {
    @Autowired
    private BookingsService bookingService;
    private ClientsModel client;
    private RoomsModel room;
    private RoomtypesModel type;
    private List<Date> booked;
    private List<RoomsModel> typesList;
    private List<BookingsModel> booksList;
    @Test
    public void ShouldinjectedBean()
    {
        assertThat(bookingService).isNotNull();
    }

    @Test
    public void ShouldAddInBDBookingWhenSave() throws Exception {
//        room.setId(2);
//        room.setCode("SU2");
//        room.setPricePerNight(100.0);
//        room.setImage("img1.jpg");
//        room.setGuests(2);
//        room.setRoomtypesByFkRoomtypeId(type);
//        room.setBooked(booked);
//
//        typesList.add(room);/////////////////////////
//        type.setId(10);
//        type.setName("Suite");
//        type.setDescription("Lorem ipsum");
//        type.setRoomsById(typesList);
//
//        booksList.add(2);///////////////////////
//        client.setId(1);
//        client.setName("Pablo");
//        client.setLastname("P");
//        client.setEmail("email@gmail.com");
//        client.setBookingsById(booksList);
//
//        BookingsModel booking = new BookingsModel();
//        booking.setId(23);
//        booking.setCheckIn(new Date(Calendar.getInstance().getTime().getTime()));
//        booking.setCheckOut(new Date(Calendar.getInstance().getTime().getTime()));
//        booking.setTotalPrice(600.0);
//        booking.setClientsByFkClientId(client);
//        booking.setSafebox(true);
//        booking.setWedge(false);
//        booking.setLaundry(true);
//        booking.setParking(false);
//        booking.setRoomsByFKRoomId(room);
//
//        long id = bookingService.saveOrUpdate(booking);
//        assertThat(booking.getId()).isEqualTo(id);
    }
}






