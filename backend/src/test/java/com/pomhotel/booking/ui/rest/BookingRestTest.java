package com.pomhotel.booking.ui.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pomhotel.booking.BookingApplication;
import com.pomhotel.booking.application.models.BookingsModel;
import com.pomhotel.booking.application.models.RoomsModel;
import com.pomhotel.booking.application.models.RoomtypesModel;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = BookingApplication.class)
@AutoConfigureMockMvc
public class BookingRestTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private BookingRest bookingMock;

    @Before("")
    public void setup(){
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    @DisplayName("Test: Access to bookings endpoint")
    public void ShouldReturnOkWhenVisitBookings() throws  Exception{
        mvc.perform(get("/boot/bookings").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test: Find room by id on API REST")
    void ShouldfindBookingByIdOnApi() throws Exception {
        List<RoomsModel> rooms = new ArrayList<>();
        RoomtypesModel type = new RoomtypesModel();
        type.setId(1);
        type.setName("Suite");
        type.setDescription("description");

        RoomsModel room = new RoomsModel();
        room.setId(1);
        room.setCode("SU3");
        room.setDescription("description");
        room.setPricePerNight(100.0);
        room.setImage("img.jpg");
        room.setGuests(2);
        room.setRoomtypesByFkRoomtypeId(type);

        BookingsModel book = new BookingsModel();
        book.setId(1);
        book.setTotalPrice(2500.00);
        book.setCheckIn(new java.sql.Date(Calendar.getInstance ().getTime ().getTime ()));
        book.setCheckOut(new java.sql.Date(Calendar.getInstance ().getTime ().getTime ()));
        book.setRoomsByFKRoomId(room);

        when(bookingMock.getBooking(1)).thenReturn(book);
        this.mvc.perform(get("/boot/booknow/1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalPrice").value(2500.00))
                .andExpect(jsonPath("$.id").value(1));
    }





    static byte[] toJson(Object object ) throws  Exception {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create();
        return gson.toJson(object).getBytes();
    }












}
