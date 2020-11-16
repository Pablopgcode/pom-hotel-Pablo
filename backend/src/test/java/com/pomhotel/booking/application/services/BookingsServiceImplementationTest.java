package com.pomhotel.booking.application.services;

import com.pomhotel.booking.application.models.BookingsModel;
import com.pomhotel.booking.application.models.RoomsModel;
import com.pomhotel.booking.application.models.RoomtypesModel;
import com.pomhotel.booking.ui.rest.BookingRest;
import com.pomhotel.booking.ui.servicies.BookingLogicalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import java.sql.Date;
import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@AutoConfigureMockMvc
public class BookingsServiceImplementationTest {

    BookingsModel bookingsModel = new BookingsModel();
    List<RoomsModel> rooms = new ArrayList<>();
    List<BookingsModel> bookings = new ArrayList<>();
    RoomtypesModel type = new RoomtypesModel();

    @Autowired
    private BookingsService bookingService;
    @Autowired
    private RoomsService roomsService;
    @Autowired
    private ClientLoginService clientsLoginService;
    @Autowired
    private BookingLogicalService bookingLogicalService;

    @BeforeEach
    void setUp(){

        RoomsModel room1 = new RoomsModel();
        RoomsModel room2 = new RoomsModel();

        type.setId(9);
        type.setName("Suite");
        type.setDescription("description");

        room1.setId(90);
        room1.setCode("SU3");
        room1.setDescription("description");
        room1.setPricePerNight(100.0);
        room1.setImage("img.jpg");
        room1.setGuests(2);
        room1.setRoomtypesByFkRoomtypeId(type);
        room2.setId(91);
        room2.setCode("SU4");
        room2.setDescription("description 2");
        room2.setPricePerNight(150.0);
        room2.setImage("img2.jpg");
        room2.setGuests(2);
        room2.setRoomtypesByFkRoomtypeId(type);

        rooms.add(room1);
        rooms.add(room2);

        bookingsModel.setTotalPrice(2500.00);
        bookingsModel.setCheckIn(new java.sql.Date(Calendar.getInstance ().getTime ().getTime ()));
        bookingsModel.setCheckOut(new java.sql.Date(Calendar.getInstance ().getTime ().getTime ()));
        bookingsModel.setRoomsByFKRoomId(room1);

        bookings.add(bookingsModel);
    }

    @Test
    @DisplayName("Bean injection")
    public void ShouldinjectedBean() {
        assertThat(bookingService).isNotNull();
    }


    @Test
    @DisplayName("Test: Obtain booking by id")
    public void ShouldGetBookingById() throws Exception {
        bookingsModel.setId(108);
        var bookingService = Mockito.mock(BookingsService.class);
        Mockito.when(bookingService.findById(108)).thenReturn(bookingsModel);
        BookingRest bookingRest = new BookingRest(roomsService, bookingService, clientsLoginService, bookingLogicalService);
        assertEquals(bookingRest.getBooking(108), bookingsModel);
    }

    @Test
    @DisplayName("Test: Create bookings with service")
    public void ShouldAddInBDBookingWhenSave() throws Exception {
        var bookingService = Mockito.mock(BookingsService.class);
        Mockito.when(bookingService.saveOrUpdate(bookingsModel)).thenReturn(bookingsModel.getId());
        Mockito.when(bookingService.findById(bookingsModel.getId())).thenReturn(bookingsModel);
        BookingRest bookingRest = new BookingRest(roomsService, bookingService, clientsLoginService, bookingLogicalService);
        BookingsModel model = bookingService.findById(bookingService.saveOrUpdate(bookingsModel));
        assertNotNull(bookingRest);
        assertNotEquals(null, bookingRest);
        assertEquals(model.getTotalPrice(), 2500.00 );
    }

    @Test
    @DisplayName("Test: Get all bookings")
    public void ShouldGetAllBookings() throws Exception {
        var bookingService = Mockito.mock(BookingsService.class);
        Mockito.when(bookingService.findAll()).thenReturn(bookings);
        assertEquals(1,bookings.size());
    }


    @Test                                             /////////////////////////////////   INCOMPLETO
    @DisplayName("Test: Get all reserved dates of a room")
    public void ShouldGetAllReservedDatesOfARoom() throws Exception {
        List<Date> reserved = bookingService.getReservedDates(1);
    }
}































