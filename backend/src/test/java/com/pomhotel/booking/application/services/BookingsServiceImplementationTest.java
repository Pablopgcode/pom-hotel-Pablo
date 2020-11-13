package com.pomhotel.booking.application.services;

import com.pomhotel.booking.application.models.BookingsModel;
import com.pomhotel.booking.ui.rest.BookingRest;
import com.pomhotel.booking.ui.servicies.BookingLogicalService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@AutoConfigureMockMvc
public class BookingsServiceImplementationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private BookingsService bookingService;
    private RoomsService roomsService;
    private ClientLoginService clientsLoginService;
    private BookingLogicalService bookingLogicalService;

    @Test
    public void ShouldinjectedBean(){
        assertThat(bookingService).isNotNull();
    }


    @Test
    void TestGetBookingById() throws Exception{
         BookingsModel bookingsModel = new BookingsModel();
         bookingsModel.setId(1);
         bookingsModel.setTotalPrice(50.00);
         var bookingService = Mockito.mock(BookingsService.class);
         Mockito.when(bookingService.findById(1)).thenReturn(bookingsModel);
         BookingRest bookingRest = new BookingRest(roomsService, bookingService, clientsLoginService, bookingLogicalService);
         assertEquals(bookingRest.getBooking(1), bookingsModel);
    }

    @Test
    public void ShouldAddInBDBookingWhenSave() throws Exception {}



}

























    /*@Test
    void testGetAll() throws Exception{
        this.mockMvc.perform(get("api/bookings/{id}").param("id", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalPrice").value(20.00));
    }
    @Test
    void testGetById() throws Exception{
        this.mockMvc.perform(post("/greeting")
                .content("Manuel"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Hello, Manuel!"));
    }*/









