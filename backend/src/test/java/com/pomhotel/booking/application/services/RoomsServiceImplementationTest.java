package com.pomhotel.booking.application.services;

import com.pomhotel.booking.application.models.BookingsModel;
import com.pomhotel.booking.application.models.RoomsModel;
import com.pomhotel.booking.application.models.RoomtypesModel;
import com.pomhotel.booking.ui.rest.BookingRest;
import com.pomhotel.booking.ui.rest.HomeRest;
import com.pomhotel.booking.ui.servicies.BookingLogicalService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class RoomsServiceImplementationTest {
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
        assertThat(roomsService).isNotNull();
    }

    @Test
    @DisplayName("Test: Obtain room by id")
    public void ShouldGetRoomById() throws Exception {
        RoomsModel room = new RoomsModel();
        room.setId(1);
        var roomService = Mockito.mock(RoomsService.class);
        Mockito.when(roomService.findById(1)).thenReturn(room);
        assertEquals(1, room.getId());
    }


    @Test
    @DisplayName("Test: Creates or update rooms on BD")
    public void ShouldAddInBDRoomWhenSave() throws Exception {
        RoomsModel room = new RoomsModel();
        RoomtypesModel type = new RoomtypesModel();
        type.setId(2);
        type.setName("Suite");
        type.setDescription("description");
        room.setId(25);
        room.setCode("SU6");
        room.setDescription("description");
        room.setPricePerNight(100.0);
        room.setImage("img.jpg");
        room.setGuests(2);
        room.setRoomtypesByFkRoomtypeId(type);
        roomsService.saveOrUpdate(room);
        assertEquals(25, room.getId());
    }

    @Test
    @DisplayName("Test: Get all rooms")
    public void ShouldGetAllRooms() throws Exception {
        List<RoomsModel> rooms =  (List<RoomsModel>)roomsService.findAll();
        assertEquals(17,rooms.size());
    }

    @Test
    @DisplayName("Test: Get filtered room")
    public void ShouldGetAFilteredRoom() throws Exception {
        List<RoomsModel> rooms = roomsService.findApplyingFilter(2,300,300,1);
        assertEquals(3,rooms.size());
    }
}
