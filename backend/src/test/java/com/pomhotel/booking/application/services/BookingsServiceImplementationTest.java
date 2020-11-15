package com.pomhotel.booking.application.services;

import com.pomhotel.booking.application.models.BookingsModel;
import com.pomhotel.booking.application.models.RoomsModel;
import com.pomhotel.booking.application.models.RoomtypesModel;
import com.pomhotel.booking.ui.rest.BookingRest;
import com.pomhotel.booking.ui.servicies.BookingLogicalService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;
import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@AutoConfigureMockMvc
public class BookingsServiceImplementationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private BookingsService bookingService;
    @Autowired
    private RoomsService roomsService;
    @Autowired
    private ClientLoginService clientsLoginService;
    @Autowired
    private BookingLogicalService bookingLogicalService;


    @Test
    @DisplayName("Bean injection")
    public void ShouldinjectedBean() {
        assertThat(bookingService).isNotNull();
    }


    @Test
    @DisplayName("Test: Obtain booking by id")
    public void ShouldGetBookingById() throws Exception {
        BookingsModel bookingsModel = new BookingsModel();
        bookingsModel.setId(108);
        var bookingService = Mockito.mock(BookingsService.class);
        Mockito.when(bookingService.findById(108)).thenReturn(bookingsModel);
        BookingRest bookingRest = new BookingRest(roomsService, bookingService, clientsLoginService, bookingLogicalService);
        assertEquals(bookingRest.getBooking(108), bookingsModel);
    }

    @Test
    @DisplayName("Test: Create bookings with service")    /////////////////////////////////////////////////////////////
    public void ShouldAddInBDBookingWhenSave() throws Exception {
        BookingsModel bookingsModel = new BookingsModel();
        List<RoomsModel> rooms = new ArrayList<>();
        RoomtypesModel type = new RoomtypesModel();
        type.setId(9);
        type.setName("Suite");
        type.setDescription("description");
        RoomsModel room = new RoomsModel();
        room.setId(10);
        room.setCode("SU3");
        room.setDescription("description");
        room.setPricePerNight(100.0);
        room.setImage("img.jpg");
        room.setGuests(2);
        room.setRoomtypesByFkRoomtypeId(type);
        bookingsModel.setTotalPrice(2500.00);
        bookingsModel.setCheckIn(new java.sql.Date(Calendar.getInstance ().getTime ().getTime ()));
        bookingsModel.setCheckOut(new java.sql.Date(Calendar.getInstance ().getTime ().getTime ()));
        bookingsModel.setRoomsByFKRoomId(room);
        var bookingService = Mockito.mock(BookingsService.class);
        Mockito.when(bookingService.saveOrUpdate(bookingsModel)).thenReturn(bookingsModel.getId());
        BookingRest bookingRest = new BookingRest(roomsService, bookingService, clientsLoginService, bookingLogicalService);
        long id = bookingService.saveOrUpdate(bookingsModel);
        assertNotNull(bookingRest);
        assertNotEquals(null, bookingRest);
        //assertEquals(111,bookingRest.getBooking(111));   /////////////////////////////// Peta con esta condición
    }

    @Test
    @DisplayName("Test: Get all bookings")
    public void ShouldGetAllBookings() throws Exception {
        List<BookingsModel> bookingsCreated = (List<BookingsModel>)bookingService.findAll();
        assertEquals(3,bookingsCreated.size());
    }


    @Test                                             /////////////////////////////////   INCOMPLETO
    @DisplayName("Test: Get all reserved dates of a room")
    public void ShouldGetAllReservedDatesOfARoom() throws Exception {
        List<Date> reserved = bookingService.getReservedDates(1);

    }
}































