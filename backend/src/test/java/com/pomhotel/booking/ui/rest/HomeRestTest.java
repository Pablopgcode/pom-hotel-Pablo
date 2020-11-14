package com.pomhotel.booking.ui.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.pomhotel.booking.BookingApplication;
import com.pomhotel.booking.application.models.RoomsModel;
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
import java.util.List;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = BookingApplication.class)
@AutoConfigureMockMvc
public class HomeRestTest {

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
            RoomsModel room = new RoomsModel();
            room.setId(1);
            room.setPricePerNight(300.00);
            room.setCode("SU1");
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
            final Gson gson = new Gson();
            List<RoomsModel> rooms = new ArrayList<>();
            RoomsModel room1 = new RoomsModel();
            RoomsModel room2 = new RoomsModel();
            room1.setId(1);
            room1.setPricePerNight(300.00);
            room1.setCode("SU1");
            room2.setId(2);
            room2.setPricePerNight(200.00);
            room2.setCode("SU2");
            rooms.add(room1);
            rooms.add(room2);
            when(roomsMock.roomsList()).thenReturn(rooms);
            this.mvc.perform(get("/boot/rooms")
                    .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$").value(gson.fromJson((JsonElement)rooms, RoomsModel.class)));  ////////////////////////////////  PETE

        }

        @Test
        @DisplayName("Test: Find a filtered room")   ////////////////////////////////////// INCOMPLETO
        void ShouldfindAFilterRoomsOnApi() throws Exception {
            final Gson gson = new Gson();
            List<RoomsModel> rooms = new ArrayList<>();



        }

        static byte[] toJson(Object object ) throws  Exception {
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create();
            return gson.toJson(object).getBytes();
        }
}
