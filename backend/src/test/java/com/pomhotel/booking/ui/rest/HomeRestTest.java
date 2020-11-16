package com.pomhotel.booking.ui.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.pomhotel.booking.BookingApplication;
import com.pomhotel.booking.application.models.RoomsModel;
import com.pomhotel.booking.ui.dto.SearchDTO;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = BookingApplication.class)
@AutoConfigureMockMvc
public class HomeRestTest {

        List<RoomsModel> rooms = new ArrayList<>();
        SearchDTO search = new SearchDTO();
        final Gson gson = new Gson();
        RoomsModel room = new RoomsModel();
        RoomsModel room1 = new RoomsModel();
        RoomsModel room2 = new RoomsModel();

        @Autowired
        private MockMvc mvc;

        @Autowired
        private WebApplicationContext context;

        @MockBean
        private HomeRest roomsMock;

        @Before("")
        public void setup(){
            mvc = MockMvcBuilders
                    .webAppContextSetup(context)
                    .build();
        }

        @BeforeEach
        public void setUp() {
            room.setId(1);
            room.setPricePerNight(300.00);
            room.setCode("SU1");
            room1.setId(1);
            room1.setPricePerNight(320.00);
            room1.setGuests(2);
            room1.setCode("SU1");
            room2.setId(2);
            room2.setPricePerNight(200.00);
            room2.setCode("SU2");
            rooms.add(room1);
            rooms.add(room2);

            search.setCheckin("2020-11-15");
            search.setCheckout("2020-11-17");
            search.setGuests("2");
            search.setMinprice("50");
            search.setMaxprice("1000");
            search.setType("1");
        }

        @Test
        @DisplayName("Test: Access to rooms endpoint")
        public void ShouldReturnOkWhenVisitRooms() throws  Exception{
            mvc.perform(get("/boot/rooms").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
        }

        @Test
        @DisplayName("Test: Find room by id on API REST")
        void ShouldfindRoomByIdOnApi() throws Exception {
            when(roomsMock.getRoomsById(1)).thenReturn(room);
            this.mvc.perform(get("/boot/rooms/1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pricePerNight").value(300.00))
                .andExpect(jsonPath("$.code").value("SU1"));
        }

        @Test
        @DisplayName("Test: Find all rooms on API REST")
        void ShouldfindAllRoomsOnApi() throws Exception {
            when(roomsMock.roomsList()).thenReturn(rooms);
            this.mvc.perform(get("/boot/rooms")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
        }

        @Test
        @DisplayName("Test: Find a filtered rooms")
        @Disabled("Not finished yet")
        void ShouldfindAFilterRoomsOnApi() throws Exception {
            when(roomsMock.apirooms(search)).thenReturn(rooms);
            this.mvc.perform(post("/boot/rooms")
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.toJson(search)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                //.andExpect(jsonPath("$[0].getCode").value("SU1"));
                .andExpect(jsonPath("$[1].getCode").value(rooms.get(1).getDescription()));
        }

        static byte[] toJson(Object object ) throws  Exception {
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create();
            return gson.toJson(object).getBytes();
        }
}
