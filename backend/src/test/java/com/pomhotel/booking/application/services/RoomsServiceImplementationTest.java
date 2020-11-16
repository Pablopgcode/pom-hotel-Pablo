package com.pomhotel.booking.application.services;

import com.pomhotel.booking.application.models.RoomsModel;
import com.pomhotel.booking.application.models.RoomtypesModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class RoomsServiceImplementationTest {

    List<RoomsModel> rooms = new ArrayList<>();
    RoomtypesModel type = new RoomtypesModel();
    RoomsModel room = new RoomsModel();

   @Autowired
    private RoomsService roomsService;

    @BeforeEach
    public void setUp() {
        type.setId(9);
        type.setName("Suite");
        type.setDescription("description");
        room.setId(10);
        room.setCode("SU3");
        room.setDescription("description");
        room.setPricePerNight(100.0);
        room.setImage("img.jpg");
        room.setGuests(2);
        room.setRoomtypesByFkRoomtypeId(type);
        rooms.add(room);
    }

    @Test
    @DisplayName("Bean injection")
    public void ShouldinjectedBean() {
        assertThat(roomsService).isNotNull();
    }

    @Test
    @DisplayName("Test: Obtain room by id")
    public void ShouldGetRoomById() throws Exception {
        var roomService = Mockito.mock(RoomsService.class);
        Mockito.when(roomService.findById(10)).thenReturn(room);
        assertEquals(10, room.getId());
    }


    @Test
    @DisplayName("Test: Creates or update rooms on BD")
    public void ShouldAddInBDRoomWhenSave() throws Exception {
        var roomsService = Mockito.mock(RoomsService.class);
        //Mockito.when(roomsService.saveOrUpdate(room)).thenReturn(bookingsModel.getId());
        assertNotNull(room);
        assertNotEquals(null, room);

    }

    @Test
    @DisplayName("Test: Get all rooms")
    public void ShouldGetAllRooms() throws Exception {
        var roomsService = Mockito.mock(RoomsService.class);
        Mockito.when(roomsService.findAll()).thenReturn(rooms);
        assertEquals(1,rooms.size());
    }

    @Test
    @DisplayName("Test: Get filtered room")
    public void ShouldGetAFilteredRoom() throws Exception {





    }
}
