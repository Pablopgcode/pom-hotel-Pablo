package com.pomhotel.booking.application.services;

import com.pomhotel.booking.application.models.BookingsModel;
import com.pomhotel.booking.ui.rest.BookingRest;
import com.pomhotel.booking.ui.servicies.BookingLogicalService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
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
    @DisplayName("Inyección del Bean")
    public void ShouldinjectedBean() {
        assertThat(bookingService).isNotNull();
    }


    @Test
    @DisplayName("Test: Obtiene booking por id")
    public void ShouldGetBookingById() throws Exception {
        BookingsModel bookingsModel = new BookingsModel();
        bookingsModel.setId(1);
        var bookingService = Mockito.mock(BookingsService.class);
        Mockito.when(bookingService.findById(1)).thenReturn(bookingsModel);
        BookingRest bookingRest = new BookingRest(roomsService, bookingService, clientsLoginService, bookingLogicalService);
        assertEquals(bookingRest.getBooking(1), bookingsModel);
        System.out.println(bookingsModel.getTotalPrice());
    }

    @Test
    @DisplayName("Test: Crea bookings correctamente")
    public void ShouldAddInBDBookingWhenSave() throws Exception {
        BookingsModel bookingsModel = new BookingsModel();
        bookingsModel.setId(1);
        var bookingService = Mockito.mock(BookingsService.class);
        Mockito.when(bookingService.saveOrUpdate(bookingsModel)).thenReturn(bookingsModel.getId());
        BookingRest bookingRest = new BookingRest(roomsService, bookingService, clientsLoginService, bookingLogicalService);
        assertNotNull(bookingRest);
        assertNotEquals(null, bookingRest);
        assertEquals(bookingsModel.getId(), bookingRest.getBooking(1));
        //assertEquals(1,bookingRest.getBooking(1));
    }

    @Test
    @DisplayName("Test: Muestra todos los bookings")
    public void ShouldGetAllBookings() throws Exception {
        List<BookingsModel> bookings = new ArrayList<>();

        //List<BookingsModel> bookings = (List<BookingsModel>)bookingService.findAll();
        //assertThat(bookings).size().isGreaterThan(0);

        BookingsModel book1 = new BookingsModel();
        BookingsModel book2 = new BookingsModel();
        bookings.add(book1);
        bookings.add(book2);
        List<BookingsModel> bookingsCreated = (List<BookingsModel>)bookingService.findAll();
        assertEquals(2,bookingsCreated.size());
    }

    @Test
    @DisplayName("Test: Elimina booking por id")
    public void ShouldDelBookingById() throws Exception {
        BookingsModel bookingToDelete = bookingService.findById(109);
        var bookingService = Mockito.mock(BookingsService.class);
        //Mockito.when(bookingService.deleteById(109));
        bookingService.deleteById(109); /////
        BookingsModel deletedBooking = bookingService.findById(109);
        assertThat(deletedBooking).isNull();
    }

    @Test
    @DisplayName("Test: Elimina booking")
    public void ShouldDelBooking() throws Exception {
        BookingsModel bookingToDelete = new BookingsModel();
        bookingToDelete.setId(1);
        var bookingService = Mockito.mock(BookingsService.class);
        bookingService.delete(bookingToDelete); /////
        BookingsModel deletedBooking = bookingService.findById(109);
        assertThat(deletedBooking).isNull();
    }
}































